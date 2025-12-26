package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User updateUser(Long id, User user) {
        User updatedUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ FIXED: use email instead of username
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRole(user.getRole());

        return userRepository.save(updatedUser);
    }
}
