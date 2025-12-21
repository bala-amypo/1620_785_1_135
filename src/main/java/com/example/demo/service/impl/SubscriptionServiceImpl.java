package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.SubscriptionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private UserService userService;

    public void subscribeUser(User user) {
        // Example: using getters of User entity
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();

        // Add your subscription logic here
        System.out.println("Subscribed: " + name + " (" + email + ")");
    }
}
