package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateData(Long id, User user);

    String userDelete(Long id); // return String, not void
}
