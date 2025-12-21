package com.example.demo.service.impl;

import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isSubscribed(Long userId, Long subscriptionId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Subscription> subscription = subscriptionRepository.findById(subscriptionId);

        if (user.isPresent() && subscription.isPresent()) {
            // Placeholder logic: implement your real subscription check
            return true; // or false depending on your database check
        }
        return false;
    }

    // Example: add other methods defined in SubscriptionService here
}
