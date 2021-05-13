package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.name = :name")
    Optional<User> getUserByName(@Param("name") String name);
}