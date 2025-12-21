package com.example.demo.service.impl;

import com.example.demo.entity.Subscription;
import com.example.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Override
    public Subscription subscribe(Long eventId, Long userId) {
        return new Subscription();
    }

    @Override
    public void unsubscribe(Long eventId, Long userId) {
    }

    @Override
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return List.of();
    }

    @Override
    public boolean isSubscribed(Long eventId, Long userId) {
        return false;
    }
}
