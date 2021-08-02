package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.RoleRepository;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;
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
    public void saveUser(UserDto userDto) {
        userRepository.save(userConverter.fromUserDtoToUser(userDto));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Set<Role> getRolesFromList(List<String> roleList) {
        return roleList.stream().map(role -> roleRepository.findByName("ROLE_" + role)).collect(Collectors.toSet());
    }
}