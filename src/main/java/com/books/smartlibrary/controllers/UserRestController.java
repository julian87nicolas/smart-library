package com.books.smartlibrary.controllers;

import com.books.smartlibrary.domain.User;
import com.books.smartlibrary.exceptions.BadRequestException;
import com.books.smartlibrary.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {

    //TODO: eliminar esta simulacion de users
    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("Charles", "555659595", "Leclerc", "predestinato@ferrari.com"),
            new User("Lewis", "51566156", "Hamilton", "imissmercedes@ferrari.com"),
            new User("Max", "8181918", "Verstappen", "thego4t@verstappen.com")
    ));

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        if(name.length() < 3) {
            throw new BadRequestException("The name must be at least 3 characters");
        }
        return ResponseEntity.ok(findUserByName(name));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(findUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        users.add(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(user.getName())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }

    @PutMapping
    public ResponseEntity<User> modifyUser(@RequestBody User user) {
        User foundUser = findUserById(user.getId());
        foundUser.setName(user.getName());
        foundUser.setLastname(user.getLastname());
        foundUser.setEmail(user.getEmail());

        return ResponseEntity.ok(foundUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {
        users.remove(findUserById(id));
        return ResponseEntity.noContent().build();
    }

    public static User findUserByName(String name) {
        return users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findFirst().orElseThrow(() -> new ResourceNotFoundException("User '" + name + "' not found"));
    }

    public static User findUserById(String id) {
        return users.stream().filter(user -> user.getId().equalsIgnoreCase(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("User with id '" + id + "' not found"));
    }


}
