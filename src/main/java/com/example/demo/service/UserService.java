package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User getUserById(Long id);   // ✅ MUST exist

    User updateUser(Long id, User user);
}
