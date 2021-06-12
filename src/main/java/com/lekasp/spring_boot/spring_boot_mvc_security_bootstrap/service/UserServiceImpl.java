package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name)
                .orElseThrow(() -> new NoResultException("No User by: " + name + " present"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoResultException("No User with: " + id + " present"));
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<Set<Role>> getRoles() {
        List<Set<Role>> allRoles = new ArrayList<>();
        Set<Role> roleFirst = new HashSet<>();
        roleFirst.add(new Role((long) 0, "ADMIN"));
        Set<Role> roleSecond = new HashSet<>();
        roleSecond.add(new Role((long) 1, "USER"));
        allRoles.add(roleFirst);
        allRoles.add(roleSecond);
        System.out.println(allRoles);
        return allRoles;
    }
}