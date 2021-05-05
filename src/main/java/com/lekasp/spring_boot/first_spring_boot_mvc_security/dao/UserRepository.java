package com.lekasp.spring_boot.first_spring_boot_mvc_security.dao;

import com.lekasp.spring_boot.first_spring_boot_mvc_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByName(String name);
}