package com.lekasp.spring_boot.first_spring_boot_mvc_security.service;

import com.lekasp.spring_boot.first_spring_boot_mvc_security.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getUserByName(String name);

    User findById(Long id);

    void saveUser(User user);

    void deleteById(Long id);
}