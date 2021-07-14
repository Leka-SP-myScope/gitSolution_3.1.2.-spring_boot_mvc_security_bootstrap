package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.RoleDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.RoleRepository;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.roleRepository = roleRepository;
    }

//    public void addRolesToUsers() {
//        Role roleAdmin = roleRepository.getOne(1L);
//        Role roleUser = roleRepository.getOne(2L);
//        User userAdmin = userRepository.getOne(1L);
//        User userUser = userRepository.getOne(2L);
//        userAdmin.addRole(roleAdmin);
//        userUser.addRole(roleUser);
//        userRepository.save(userAdmin);
//        userRepository.save(userUser);
//    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(userConverter::fromUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByName(String name) {
        return userConverter.fromUserToUserDto(userRepository.getUserByName(name)
                .orElseThrow(() -> new NoResultException("No User by: " + name + " present")));
    }

    @Override
    public UserDto findById(Long id) {
        return userConverter.fromUserToUserDto(userRepository.findById(id)
                .orElseThrow(() -> new NoResultException("No User with: " + id + " present")));
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(userConverter.fromUserDtoToUser(userDto));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<String> getRolesStrings() {
        List<String> listRoles = Arrays.asList("ADMIN", "USER");
        System.out.println(listRoles);
        return listRoles;
    }

//    public Set<Role> getRolesFromList(List<String> roleList) {
//        Set<Role> allGetRoles = roleList.stream().collect(Collectors.toSet());
//    }

}