package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.Optional;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User user);
}
