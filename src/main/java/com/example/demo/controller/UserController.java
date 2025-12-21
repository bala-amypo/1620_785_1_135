package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService ser;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return ser.registerUser(user); // Make sure UserService has this method
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return ser.getAllUsers(); // Make sure UserService has this method
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return ser.getUserById(id); // Make sure UserService has this method
    }

    @PutMapping("/{id}")
    public User updateData(@PathVariable Long id, @RequestBody User user) {
        return ser.updateData(id, user); // Make sure UserService has this method
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return ser.userDelete(id); // Make sure UserService has this method returning String
    }
}
