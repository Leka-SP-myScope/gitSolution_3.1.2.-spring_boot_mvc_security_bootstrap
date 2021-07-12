package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.RoleDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    void saveRole(RoleDto roleDto);

    public Set<Role> getAdminRole();

    public Set<Role> getUserRole();

    public Set<Role> getAllRoles();

}