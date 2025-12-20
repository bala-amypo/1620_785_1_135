package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.User;
public interface UserService {

    User registerUser(User user);   // check duplicate email

    User getUserById(Long id);       // throw "User not found"
    List<User> getAllUsers();
    User UpdateData(Long id,User entity);
    String UserDelete(Long id);
}