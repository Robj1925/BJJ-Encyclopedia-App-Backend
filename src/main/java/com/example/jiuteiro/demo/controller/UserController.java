package com.example.jiuteiro.demo.controller;

import com.example.jiuteiro.demo.dto.UserRequest;
import com.example.jiuteiro.demo.exception.UserNotFoundException;
import com.example.jiuteiro.demo.model.User;
import com.example.jiuteiro.demo.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<User> getUserById(@PathVariable Integer user_id) {
        try {
            User user = userService.getUserById(user_id);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }
}
