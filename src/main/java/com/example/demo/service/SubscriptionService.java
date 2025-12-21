package com.example.demo.service;

import com.example.demo.entity.Subscription;
import java.util.List;

public interface SubscriptionService {
    Subscription subscribe(Long eventId, Long userId);
    void unsubscribe(Long eventId, Long userId);
    List<Subscription> getSubscriptionsByUser(Long userId);
    boolean isSubscribed(Long eventId, Long userId);
}
