package com.main.project.java.Controller;

import com.main.project.java.Entity.User;
import com.main.project.java.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String viewHomePage() {
        return "welcome";
    }

    @GetMapping("/mainMenu")
    public String viewMenuPage() {
        return "menu";
    }
    @GetMapping("/user")
    public String viewHomePage(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "user";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "AddUser";
    }

    @PostMapping("/saveUser")
    public String saveUser( User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedpassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedpassword);

        userService.saveUser(user);
        return "welcome";
    }

    @GetMapping("/showUserFormForUpdate/{id}")
    public String showUserFormForUpdate(@PathVariable(value = "id") int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "UpdateUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int userId) {
        this.userService.deleteUserById(userId);
        return "redirect:/user";
    }




    }
