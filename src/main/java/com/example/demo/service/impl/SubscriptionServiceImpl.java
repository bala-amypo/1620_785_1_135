package com.example.demo.service.impl;

import com.example.demo.entity.Subscription;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription subscribe(Long userId, Subscription subscription) {
        subscription.setUserId(userId);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public String unsubscribe(Long userId, Long subscriptionId) {
        subscriptionRepository.deleteByUserIdAndSubscriptionId(userId, subscriptionId);
        return "Unsubscribed successfully";
    }

    @Override
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    @Override
    public boolean isSubscribed(Long userId, Long subscriptionId) {
        return subscriptionRepository.existsByUserIdAndSubscriptionId(userId, subscriptionId);
    }
}
