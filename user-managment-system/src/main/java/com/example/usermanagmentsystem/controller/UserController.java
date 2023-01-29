package com.example.usermanagmentsystem.controller;
import org.springframework.stereotype.Controller;
import com.example.usermanagmentsystem.service.UserService;
import com.example.usermanagmentsystem.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/") // "http://localhost:8080/"
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";
    }
    @GetMapping("/newUserForm") // "http://localhost:8080/newUserForm"
    public String viewNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/updateUserForm/{id}")
    public String updateUserForm(@PathVariable Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }
    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Integer id, Model model){
        userService.deleteUserByID(id);
        return "redirect:/";
    }
}
