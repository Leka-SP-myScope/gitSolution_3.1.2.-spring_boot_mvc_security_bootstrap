package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.RoleDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;

    public RoleServiceImpl(RoleRepository roleRepository, RoleConverter roleConverter) {
        this.roleRepository = roleRepository;
        this.roleConverter = roleConverter;
    }

    @Override
    public void saveRole(RoleDto roleDto) {
        roleRepository.save(roleConverter.fromRoleDtoToRole(roleDto));
    }

    public Set<Role> getAdminRole() {
        Set<Role> adminRole = new HashSet<>();
        Role roleAdmin = new Role("ADMIN");
        adminRole.add(roleAdmin);
        return adminRole;
    }

    public Set<Role> getUserRole() {
        Set<Role> userRole = new HashSet<>();
        Role roleUser = new Role("USER");
        userRole.add(roleUser);
        return userRole;
    }

    public Set<Role> getAllRoles() {
        Set<Role> allRoles = new HashSet<>();
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        allRoles.add(roleAdmin);
        allRoles.add(roleUser);
        return allRoles;
    }
}