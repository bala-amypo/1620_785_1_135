package com.example.demo.service.impl;

import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        return user.isPresent() && subscription.isPresent();
    }

    @Override
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return subscriptionRepository.findByUserId(userId); // make sure this method exists in your repo
        } else {
            return List.of(); // empty list if user not found
        }
    }
}
