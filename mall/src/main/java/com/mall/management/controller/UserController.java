package com.mall.management.controller;

import com.mall.management.entity.User;
import com.mall.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public User searchUser(@PathVariable Integer id) {
        return userService.searchUser(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public String logout() {
        if (userService.logout()) {
            return "Logged out successfully";
        }
        return "Logout failed";
    }
}
