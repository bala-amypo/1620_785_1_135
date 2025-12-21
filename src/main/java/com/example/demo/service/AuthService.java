package com.example.demo.service;

import com.example.demo.controller.LoginRequest;
import com.example.demo.controller.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest request);
    String login(LoginRequest request);
}
