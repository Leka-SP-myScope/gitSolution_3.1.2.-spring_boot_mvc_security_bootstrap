package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.RoleDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserService {

    //void addRolesToUsers();

    List<UserDto> getAllUser();

    UserDto getUserByName(String name);

    UserDto findById(Long id);

    void saveUser(UserDto userDto);

    void deleteById(Long id);

    List<String> getRolesStrings();

}