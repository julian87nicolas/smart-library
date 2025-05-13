package com.books.smartlibrary.persistante.repositories;

import com.books.smartlibrary.domain.User;
import com.books.smartlibrary.persistante.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findById(String id);
    User findByUserId(Integer userId);
    User findByName(String name);
    User findByLastName(String lastName);
}
