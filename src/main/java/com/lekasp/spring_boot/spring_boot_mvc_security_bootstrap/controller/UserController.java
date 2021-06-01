package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.controller;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getFirstPage() {
        return "users_list";
    }

//    @GetMapping("/user")
//    public String getAllUser(Model model) {
//        List<User> allUser = userService.getAllUser();
//        model.addAttribute("allUser", allUser);
//        return "users_list";
//    }

//    @GetMapping("/user_create")
//    public String createUserAndShow(User user) {
//        return "user_create";
//    }
//
//    @PostMapping("/user_create")
//    public String createUser(User user) {
//        userService.saveUser(user);
//        return "redirect:/user";
//    }

    @GetMapping("/admin/user_delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/user";
    }

    @GetMapping("/admin/user_update/{id}")
    public String saveUserAndShow(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    @PostMapping("/admin/user_update")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/user";
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
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "user_page";
    }

    @GetMapping("/admin/user")
    public String getAllUser2(Model model) {
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "admin_page";
    }

    @GetMapping("/admin/admin_page")
    public String createUserAndShow2(User user) {
        return "admin_page";
    }

    @PostMapping("/admin/admin_page")
    public String createUser2(User user) {
        userService.saveUser(user);
        return "redirect:/admin/user";
    }
}