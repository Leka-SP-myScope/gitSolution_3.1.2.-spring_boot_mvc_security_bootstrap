package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.security;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserConverter;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserService userService;
    private UserConverter userConverter;

    @Autowired
    public MyUserDetailsService(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.of(userConverter.fromUserDtoToUser(userService.getUserByName(username)))
                .orElseThrow(() -> new UsernameNotFoundException("The entered username : "
                        + username + " is incorrect. Please, change your username"));
    }
//    Working case******************************************************************************************************
    /*private UserService userService;
    private UserConverter userConverter;

    @Autowired
    public MyUserDetailsService(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.of(userConverter.fromUserDtoToUser(userService.getUserByName(username)))
                .orElseThrow(() -> new UsernameNotFoundException("The entered username : "
                        + username + " is incorrect. Please, change your username"));
    }*/
}