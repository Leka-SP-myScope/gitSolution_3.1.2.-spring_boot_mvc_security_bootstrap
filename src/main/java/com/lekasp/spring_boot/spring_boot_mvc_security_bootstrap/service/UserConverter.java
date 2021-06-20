package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private ModelMapper modelMapper;

    public UserConverter() {
    }

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User fromUserDtoToUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setSurname(userDto.getSurname());
//        user.setPassword(userDto.getPassword());
//        user.setAge(userDto.getAge());
//        user.setEmail(userDto.getEmail());
//        user.setRoles(userDto.getRoles());
        return user;
    }

    public UserDto fromUserToUserDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setSurname(user.getSurname());
//        userDto.setPassword(user.getPassword());
//        userDto.setAge(user.getAge());
//        userDto.setEmail(user.getEmail());
//        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
