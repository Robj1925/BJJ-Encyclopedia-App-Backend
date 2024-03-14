package com.example.jiuteiro.demo.service;

import com.example.jiuteiro.demo.dto.LoginRequest;
import com.example.jiuteiro.demo.dto.UserRequest;
import com.example.jiuteiro.demo.exception.UserNotFoundException;
import com.example.jiuteiro.demo.model.User;
import com.example.jiuteiro.demo.repository.UserRepository;
import com.example.jiuteiro.demo.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //
    private UserRepository userRepository;


    public User getUserById(Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found by id: " + id);
        }

    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User saveUser(UserRequest userRequest) {
        User newUser = User
                .build(0, userRequest.getUsername(), userRequest.getPassword());

        return userRepository.save(newUser);
    }
    public boolean deleteUser(Integer id) throws UserNotFoundException {
        User findUser = getUserById(id);
        if (findUser != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public LoginMessage loginUser(LoginRequest loginRequest) {
        String msg = "";
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null) {
            String inputPassword = loginRequest.getPassword();
            String realPassword = user.getPassword();
            Boolean pwIsRight = inputPassword.equals(realPassword);
            if (pwIsRight) {
                Optional<User> user1 = userRepository.findOneByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
                if (user1.isPresent()) {
                    return new LoginMessage("Login Successful!", true);
                }
                return new LoginMessage("Login Failed!", false);
            } else {
                return new LoginMessage("Password is incorrect!", false);
            }
        } else {
            return new LoginMessage("Username does not exist", false);
        }
    }
}
