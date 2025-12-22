package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service   // ← REQUIRED
public class UserService {

    public String getUser() {
        return "User service working";
    }
}
