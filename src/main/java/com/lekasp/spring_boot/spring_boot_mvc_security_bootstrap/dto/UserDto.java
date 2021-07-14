package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private int age;
    private String email;
    private Set<Role> roles;
    private List<String> rolesNameList = new ArrayList<>();
    //private List<RoleDto> roleDtos;

/*
    Working with String value
    private String rolesName;
*/

    public UserDto() {
        //this.roleDtos = new ArrayList<>();
    }

    public UserDto(Long id, String name, String surname, String password, int age, String email, Set<Role> roles, List<String> rolesNameList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.age = age;
        this.email = email;
        this.roles = roles;
        this.rolesNameList = rolesNameList;
    }

    /*Working with String value
//    public UserDto(Long id, String name, String surname, String password, int age, String email, Set<Role> roles, String rolesName) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.password = password;
//        this.age = age;
//        this.email = email;
//        this.roles = roles;
//        this.rolesName = rolesName;
//    }

     */

//    public UserDto(Long id, String name, String surname, String password, int age, String email, Set<Role> roles, List<RoleDto> roleDtos, String rolesName) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.password = password;
//        this.age = age;
//        this.email = email;
//        this.roles = roles;
//        this.roleDtos = roleDtos;
//        this.rolesName = rolesName;
//    }

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

//    public List<RoleDto> getRoleDtos() {
//        return roleDtos;
//    }
//
//    public void setRoleDtos(List<RoleDto> roleDtos) {
//        this.roleDtos = roleDtos;
//    }

//    public void addRoleDto(RoleDto roleDto) {
//        this.roleDtos.add(roleDto);
//    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /* Working with String value
//    public String getRolesName() {
//        return rolesName;
//    }
//
//    public void setRolesName(String rolesName) {
//        this.rolesName = rolesName;
//    }*/

    public List<String> getRolesNameList() {
        return rolesNameList;
    }

    public void setRolesNameList(List<String> rolesNameList) {
        this.rolesNameList = rolesNameList;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", rolesNameList='" + rolesNameList + '\'' +
                '}';
    }
}
