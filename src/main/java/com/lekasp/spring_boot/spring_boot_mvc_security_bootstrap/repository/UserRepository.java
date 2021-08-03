package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email = :email")
    Optional<User> getUserByName(@Param("email") String email);

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email = :email")
//    UserDetails getUserByName(@Param("email") String email);
}