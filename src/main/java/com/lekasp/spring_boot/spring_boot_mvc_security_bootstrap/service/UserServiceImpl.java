package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.RoleDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
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
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

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

//    public List<Set<Role>> getRoles() {
//        List<Set<Role>> allRoles = new ArrayList<>();
//        Set<Role> roleFirst = new HashSet<>();
//        roleFirst.add(new Role((long) 0, "ADMIN"));
//        Set<Role> roleSecond = new HashSet<>();
//        roleSecond.add(new Role((long) 1, "USER"));
//        allRoles.add(roleFirst);
//        allRoles.add(roleSecond);
//        System.out.println(allRoles);
//        return allRoles;
//    }

    public List<RoleDto> getRoles() {
        List<RoleDto> allRoles = new ArrayList<>();
        RoleDto roleFirst = new RoleDto((long) 0, "ADMIN");
        RoleDto roleSecond = new RoleDto((long) 1, "USER");
        allRoles.add(roleFirst);
        allRoles.add(roleSecond);
        System.out.println(allRoles);
        return allRoles;
    }

    public Set<RoleDto> getSetRoles() {
        Set<RoleDto> allSetRoles = new HashSet<>();
        RoleDto roleFirst = new RoleDto((long) 0, "ADMIN");
        RoleDto roleSecond = new RoleDto((long) 1, "USER");
        allSetRoles.add(roleFirst);
        allSetRoles.add(roleSecond);
        System.out.println(allSetRoles);
        return allSetRoles;
    }

//    public Set<Role> getSetRoles() {
//        Set<Role> allSetRoles = new HashSet<>();
//        Role roleFirst = new Role((long) 0, "ADMIN");
//        Role roleSecond = new Role((long) 1, "USER");
//        allSetRoles.add(roleFirst);
//        allSetRoles.add(roleSecond);
//        System.out.println(allSetRoles);
//        return allSetRoles;
//    }
}