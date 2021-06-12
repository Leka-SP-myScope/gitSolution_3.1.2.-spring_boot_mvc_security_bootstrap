package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> getAllUser();

    User getUserByName(String name);

    User findById(Long id);

    void saveUser(User user);

    void deleteById(Long id);

    List<Set<Role>> getRoles();
}