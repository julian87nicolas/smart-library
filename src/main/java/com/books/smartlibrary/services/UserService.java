package com.books.smartlibrary.services;

import com.books.smartlibrary.domain.User;
import com.books.smartlibrary.persistante.entities.RoleEntity;
import com.books.smartlibrary.persistante.entities.UserEntity;
import com.books.smartlibrary.persistante.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map( user -> new UserEntity(,
                        user.getId(),
                        user.getName(),
                        user.getRole(),
                        user.getLastName(),
                        user.getGender())).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public void addUser(User user) {
        userRepository.save(new UserEntity(
                user.getUserId(),
                user.getName(),
                user.getLastName(),
                RoleEntity.builder().build(),
                user.getGender()
        ))
    }
}
