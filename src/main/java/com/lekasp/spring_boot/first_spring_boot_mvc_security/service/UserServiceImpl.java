package com.lekasp.spring_boot.first_spring_boot_mvc_security.service;

import com.lekasp.spring_boot.first_spring_boot_mvc_security.model.User;
import com.lekasp.spring_boot.first_spring_boot_mvc_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

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
//        Optional<User> optionalUser = userRepository.getUserByName(name);
//        if (optionalUser.isPresent()) {
//            return optionalUser;
//        }
//        throw new NoResultException("No User by: " + name + " present");
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoResultException("No User with: " + id + " present"));
//        Optional<User> optionalUser = userRepository.findById(id);
//        if (optionalUser.isPresent()) {
//            return optionalUser.get();
//        }
//        throw new NoResultException("No User with: " + id + " present");
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NoResultException("No User with: " + id + " present");
        }
        userRepository.deleteById(id);
    }
}