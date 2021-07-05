package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.RoleDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    private ModelMapper modelMapper;

    public RoleConverter() {
    }

    public RoleConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Role fromRoleDtoToRole(RoleDto roleDto) {
        //Role role = modelMapper.map(roleDto, Role.class);
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRole(roleDto.getRoleName());
        return role;
    }

    public RoleDto fromRoleToRoleDto(Role role) {
        //RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRoleName(role.getRole());
        return roleDto;
    }
}
