package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.controller;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/admin/users")
    public String getAllUser2(Model model) {
        List<User> allUser = userService.getAllUser();
        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role((long) 0,"ADMIN"));
        allRoles.add(new Role((long) 1,"USER"));
        User user = new User();
        user.setRoles(allRoles);
        //model.addAttribute("modelRoles", user.getRoles());
        model.addAttribute("allRoles", allRoles);
        model.addAttribute("allUser", allUser);
        //model.addAttribute("user", new User());
        model.addAttribute("user", user);
        System.out.println(model.addAttribute("user", user));
        return "admin_page";
    }

//    @GetMapping("/admin/user_create")
//    public String createUserAndShow2(User user) {
//        return "admin_page";
//    }

//    @ModelAttribute("roles")
//    public Set<Role> getRoles(){
//        Set<Role> allRoles = new HashSet<>();
//        allRoles.add(new Role((long) 0,"ADMIN"));
//        allRoles.add(new Role((long) 1,"USER"));
//        return allRoles;
//    }

    @PostMapping("/admin/users")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam("rolesSet") Set<Role> rolesSet) {
//        Set<Role> roles = user.getRoles();
//        for (Role role: roles) {
//            System.out.println(role.getRole());
//        }

        System.out.println("User without rolesSet: " + user);
        List<Set<Role>> getRoles = userService.getRoles();
        //Role roleAdmin = rolesSet.stream().filter(item ->item.getId()==0).findFirst().get();
        //Role roleUser = rolesSet.stream().filter(item ->item.getId()==1).findFirst().get();

        //getRoles.get(user.getRoles());
        //user.setRoles(allRoles.);
        //System.out.println("User with rolesSet: " + user);

        //System.out.println(rolesSet);
        System.out.println(user);
        userService.saveUser(user);
        System.out.println(user);
        return "redirect:/admin/users";
    }
}