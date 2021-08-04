package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.controller;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.RoleRepository;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.UserRepository;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserConverter;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserConverter userConverter;
    private final UserRepository userRepository;
    private List<UserDto> allUsers;

    @Autowired
    public UserController(UserService userService,
                          RoleRepository roleRepository,
                          UserConverter userConverter,
                          UserRepository userRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/user")
    public String getAllUsersForUser(Model model) {
//        allUsers = userRepository.findAllUsers().stream()
//                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());

//        allUsers = userRepository.findAll().stream()
//                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());

        allUsers = userService.getAllUser().stream()
                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());

//        allUsers = userRepository.findAll().stream()
//                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());
        model.addAttribute("allUser", allUsers);
        return "user_page";
    }

    @GetMapping("/admin/users")
    public String getAllUsersForAdmin(Model model) {
//        allUsers = userRepository.findAllUsers().stream()
//                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());

        allUsers = userService.getAllUser().stream()
                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());

//        allUsers = userRepository.findAll().stream()
//                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());


//        allUsers = userRepository.findAll().stream()
//                .map(userConverter::fromUserToUserDto).collect(Collectors.toList());
        model.addAttribute("allUser", allUsers);
        model.addAttribute("listRoles", roleRepository.findAll());
        model.addAttribute("user", new UserDto());
        return "admin_page";
    }

    @PostMapping("/admin/users")
    public String createUser(@ModelAttribute("user") UserDto userDto,
                             @RequestParam("rolesNameList") List<String> rolesNameList) {
        User user = userConverter.fromUserDtoToUser(userDto);
        user.setRoles(userService.getRolesFromList(rolesNameList));
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

//    Working case******************************************************************************************************
    /*private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService,
                          RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/user")
    public String getAllUser(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
        return "user_page";
    }

    @GetMapping("/admin/users")
    public String getAllUser2(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
        model.addAttribute("listRoles", roleRepository.findAll());
        model.addAttribute("user", new UserDto());
        return "admin_page";
    }

    @PostMapping("/admin/users")
    public String createUser(@ModelAttribute("user") UserDto userDto,
                             @RequestParam("rolesNameList") List<String> rolesNameList) {
        userDto.setRoles(userService.getRolesFromList(rolesNameList));
        userService.saveUser(userDto);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }*/
}