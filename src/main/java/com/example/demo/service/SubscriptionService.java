package com.example.demo.service;

import com.example.demo.entity.Subscription;

public interface SubscriptionService {

    Subscription subscribe(Long channelId, String userEmail);
}
