package com.lekasp.spring_boot.first_spring_boot_mvc_security.service;

import com.lekasp.spring_boot.first_spring_boot_mvc_security.dao.UserRepository;
import com.lekasp.spring_boot.first_spring_boot_mvc_security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return userRepository.getAllUser();
    }

    @Override
    public Optional<User> getUserByName(String name) {
        Optional<User> optionalUser = userRepository.getUserByName(name);
        if (optionalUser.isPresent() && name != null) {
            return userRepository.getUserByName(name);
        }
        throw new NoResultException("No User by: " + name + " present");
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent() && id != null) {
            return optionalUser.get();
        }
        throw new NoResultException("No User by: " + id + " present");
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

//    @Override
//    @Transactional
//    public void updateUser(User user) {
//        userDao.updateUser(user);
//    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}