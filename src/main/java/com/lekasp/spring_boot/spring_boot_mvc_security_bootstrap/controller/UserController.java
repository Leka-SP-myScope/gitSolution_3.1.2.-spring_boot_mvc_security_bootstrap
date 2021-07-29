package com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.controller;

import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.RoleDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.dto.UserDto;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.Role;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.model.User;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.repository.RoleRepository;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.RoleConverter;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.RoleService;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserConverter;
import com.lekasp.spring_boot.spring_boot_mvc_security_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;
    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final RoleConverter roleConverter;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService,
                          UserConverter userConverter,
                          RoleRepository roleRepository,
                          RoleService roleService,
                          RoleConverter roleConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
        this.roleRepository = roleRepository;
        this.roleService = roleService;
        this.roleConverter = roleConverter;
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

//    @GetMapping("/admin/user_delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteById(id);
//        return "redirect:/user";
//    }

//    @GetMapping("/admin/user_update/{id}")
//    public String saveUserAndShow(@PathVariable("id") Long id, Model model) {
//        User user = userConverter.fromUserDtoToUser(userService.findById(id));
//        model.addAttribute("user", user);
//        return "user_update";
//    }

//    @PostMapping("/admin/user_update")
//    public String saveUser(UserDto userDto) {
//        userService.saveUser(userDto);
//        return "redirect:/user";
//    }

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
        List<UserDto> allUser = userService.getAllUser();
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
        //System.out.println(userDto);
        return "redirect:/admin/users";
    }

//    @GetMapping("/admin/edit/{id}")
//    public String editUserAndShow(@PathVariable("id") Long id, Model model) {
//        //UserDto userDto = userService.findById(id);
//        User user = userConverter.fromUserDtoToUser(userService.findById(id));
//        model.addAttribute("user", user);
//        model.addAttribute("listRoles", roleRepository.findAll());
//        return "redirect:/admin/users";
//    }

    //@ModelAttribute("user")UserDto userDto,
    @PostMapping("/admin/edit/{id}")
    public String editUser(@ModelAttribute("user") UserDto userDto,
                           @PathVariable Long id,
                           @RequestParam("rolesNameList") List<String> rolesNameList) {
        //userDto.setRoles(userService.getRolesFromList(rolesNameList));
        //userService.updateUser(userDto, id);
        //userService.saveUser(userDto);

        //get user from DB by id
//        UserDto existingUser = userService.findById(id);
//        existingUser.setId(id);
//        existingUser.setName(userDto.getName());
//        existingUser.setSurname(userDto.getSurname());
//        existingUser.setAge(userDto.getAge());
//        existingUser.setEmail(userDto.getEmail());
//        existingUser.setPassword(userDto.getPassword());

        UserDto userFromDB = userService.findById(id);
        System.out.println("Before edit = " + userFromDB);
        UserDto existingUser = userService.updateUser(userDto, id);

        System.out.println(userDto);
        //System.out.println("User from DB = " + userFromDB);
        System.out.println("Existing User = " + existingUser);
        System.out.println(rolesNameList);
        userDto.setRoles(userService.getRolesFromList(rolesNameList));

        existingUser.setRoles(userService.getRolesFromList(rolesNameList));
        System.out.println(userDto);

        System.out.println("Existing User with Role = " + existingUser);
        userService.saveUser(userDto);

        userService.saveUser(existingUser);

        return "redirect:/admin/users";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

//    @PostMapping("/admin/edit")
//    public String saveUser(UserDto userDto) {
//        userService.saveUser(userDto);
//        return "redirect:/admin/users";
//    }


//    @GetMapping("/admin/users")
//    public String getAllUser2(Model model) {
//        List<UserDto> allUser = userService.getAllUser();
///*
//        Working with String value
//        List<String> listRoles = Arrays.asList("ADMIN", "USER");
//*/
//        UserDto user = new UserDto();
//        model.addAttribute("listRoles", roleRepository.findAll());
//        //model.addAttribute("listRoles", userService.getRolesStrings());
//        model.addAttribute("allUser", allUser);
//        model.addAttribute("user", user);
//        //System.out.println(model.addAttribute("user", user));
//        return "admin_page";
//    }
//    @PostMapping("/admin/users")
//    public String createUser(@ModelAttribute("user") UserDto userDto,
//                             @RequestParam("rolesSet") Set<Role> rolesSet) {
////        Set<Role> roles = user.getRoles();
////        for (Role role: roles) {
////            System.out.println(role.getRole());
////        }
//        Set<Role> allRoles = userService.getSetRoles();
//
//        Set<RoleDto> allRolesDto = new HashSet<>((userService.getRoles()));
//        System.out.println(allRolesDto);
//
//
////        if (rolesSet.contains(0)) {
////            userDto.setRoles(allRoles);
//
////            for (Role role: allRoles) {
////                userDto.setRoles(allRoles);
////            }
////        }
//
//        System.out.println("User without rolesSet: " + userDto);
//        List<RoleDto> getRoles = userService.getRoles();
//        //Set<Role> roles = getRoles.get(0);
//
//        //List<Set<Role>> getRoles = userService.getRoles();
//        //Role roleAdmin = rolesSet.stream().filter(item ->item.getId()==0).findFirst().get();
//        //Role roleAdmin1 = rolesSet.stream().filter(item ->item.getId()==0).findFirst().isPresent();
//
////        if (rolesSet.stream().anyMatch(item -> item.getId() == 0)) {
////            Set<Role> roleAdmin = new HashSet<>();
////            roleAdmin.add(new Role((long) 0, "ADMIN"));
////            userDto.setRoles(roleAdmin);
////        } else if (rolesSet.stream().anyMatch(item -> item.getId() == 1)) {
////            Set<Role> roleUser = new HashSet<>();
////            roleUser.add(new Role((long) 1, "USER"));
////            userDto.setRoles(roleUser);
////        }
//        //Role roleUser = rolesSet.stream().filter(item ->item.getId()==1).findFirst().get();
//
//        //getRoles.get(user.getRoles());
//        //user.setRoles(allRoles.);
//        //System.out.println("User with rolesSet: " + user);
//
//        //System.out.println(rolesSet);
//        System.out.println(userDto);
//        //rolesSet.contains(userDto)
//
//
//        userService.saveUser(userDto);
//        System.out.println(userDto);
//        return "redirect:/admin/users";
//    }

/*
    Working with String value
    @PostMapping("/admin/users")
    public String createUser(@ModelAttribute("user") UserDto userDto,
                             @RequestParam("rolesName") String rolesName,
                             Model model) {
        if(rolesName.equals("ADMIN")) {
            userDto.setRoles(roleService.getAdminRole());
        } else if (rolesName.equals("USER")) {
            userDto.setRoles(roleService.getUserRole());
        } else {
            userDto.setRoles(roleService.getAllRoles());
        }
        List<UserDto> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "redirect:/admin/users";
    }
*/

   /* @PostMapping("/admin/users")
    public String createUser(@ModelAttribute("user") UserDto userDto,
                             @RequestParam("rolesName") String rolesName,
                             Model model) {
        System.out.println(rolesName);
        System.out.println(userDto);



        if(rolesName.equals("ADMIN")) {
            //userDto.addRoleDto(new RoleDto("ADMIN"));
            userDto.setRoles(roleService.getAdminRole());
        } else if (rolesName.equals("USER")) {
            //userDto.addRoleDto(new RoleDto("USER"));
            userDto.setRoles(roleService.getUserRole());
        } else {
            userDto.setRoles(roleService.getAllRoles());
        }
        //Set<Role> allRoles = userService.getSetRoles();

        //Set<RoleDto> allRolesDto = new HashSet<>((userService.getRoles()));
        //System.out.println(allRolesDto);

        System.out.println("User with rolesSet: " + userDto);
        //List<RoleDto> getRoles = userService.getRoles();

        //Role roleAdmin = rolesSet.stream().filter(item ->item.getId()==0).findFirst().get();
        //Role roleAdmin1 = rolesSet.stream().filter(item ->item.getId()==0).findFirst().isPresent();

//        if (rolesSet.stream().anyMatch(item -> item.getId() == 0)) {
//            Set<Role> roleAdmin = new HashSet<>();
//            roleAdmin.add(new Role((long) 0, "ADMIN"));
//            userDto.setRoles(roleAdmin);
//        } else if (rolesSet.stream().anyMatch(item -> item.getId() == 1)) {
//            Set<Role> roleUser = new HashSet<>();
//            roleUser.add(new Role((long) 1, "USER"));
//            userDto.setRoles(roleUser);
//        }

//        Role saveRole = (userDto.getRoles()).stream().filter(item ->item.getRole().equals(rolesName)).findFirst().get();
//        System.out.println(userDto);
        userService.saveUser(userDto);
//        Role saveRolefromDB = (userDto.getRoles()).stream().filter(item ->item.getRole().equals(rolesName)).findAny().get();
//        roleService.saveRole(roleConverter.fromRoleToRoleDto(saveRolefromDB));
        System.out.println(userDto);

        List<UserDto> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "redirect:/admin/users";
    }*/
}