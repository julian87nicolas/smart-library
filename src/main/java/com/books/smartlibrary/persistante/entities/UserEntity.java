package com.books.smartlibrary.persistante.entities;

import com.books.smartlibrary.domain.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="authors")
public class UserEntity {
    @Id
    @GeneratedValue
    Integer userId;
    String id;
    String name;
    String lastName;
    Gender gender;

    @ManyToOne
    RoleEntity role;

    @OneToMany
    List<OrderEntity> orders;

    public UserEntity(String id, String name, String lastName, RoleEntity role, Gender gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.gender = gender;
    }
}
