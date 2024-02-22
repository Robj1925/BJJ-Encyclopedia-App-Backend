package com.example.jiuteiro.demo.controller;

import com.example.jiuteiro.demo.model.User;
import com.example.jiuteiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/addUser")
    public User postUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
