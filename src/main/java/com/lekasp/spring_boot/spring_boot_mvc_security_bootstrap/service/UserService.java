package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDto> getAllUser();

    UserDto getUserByName(String name);

    void saveUser(UserDto userDto);

    void deleteById(Long id);

    Set<Role> getRolesFromList(List<String> roleList);
}