package com.lekasp.spring_boot.first_spring_boot_mvc_security.repository;

import com.lekasp.spring_boot.first_spring_boot_mvc_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.name = :name")
    Optional<User> getUserByName(@Param("name") String name);
}