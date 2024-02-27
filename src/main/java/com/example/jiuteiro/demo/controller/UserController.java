package com.example.jiuteiro.demo.controller;

import com.example.jiuteiro.demo.dto.UserRequest;
import com.example.jiuteiro.demo.model.User;
import com.example.jiuteiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{user_id}")
    public User getUserById(@PathVariable Integer user_id) {
        return userService.getUserById(user_id);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }
}
