package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Override
    public String subscribe(Long userId) {
        // Business logic can be added later
        return "User with ID " + userId + " subscribed successfully";
    }
}
