package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;

import java.util.List;
import java.util.Set;

public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private int age;
    private String email;
    //private Set<Role> roles;
    private List<RoleDto> roleDtos;

    public List<RoleDto> getRoleDtos() {
        return roleDtos;
    }

    public void setRoleDtos(List<RoleDto> roleDtos) {
        this.roleDtos = roleDtos;
    }

    public UserDto() {
    }

    public UserDto(Long id, String name, String surname, String password, int age, String email, List<RoleDto> roleDtos) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.age = age;
        this.email = email;
        this.roleDtos = roleDtos;
    }

//    public UserDto(Long id, String name, String surname, String password, int age, String email, Set<Role> roles) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.password = password;
//        this.age = age;
//        this.email = email;
//        this.roles = roles;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", roleDtos=" + roleDtos +
                '}';
    }
}
