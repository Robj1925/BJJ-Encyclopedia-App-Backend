package com.example.jiuteiro.demo.service;

import com.example.jiuteiro.demo.dto.UserRequest;
import com.example.jiuteiro.demo.exception.UserNotFoundException;
import com.example.jiuteiro.demo.model.User;
import com.example.jiuteiro.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
