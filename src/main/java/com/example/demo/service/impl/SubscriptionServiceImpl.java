package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subRepo;
    private final EventRepository eventRepo;
    private final UserRepository userRepo;

    public SubscriptionServiceImpl(SubscriptionRepository subRepo,
                                   EventRepository eventRepo,
                                   UserRepository userRepo) {
        this.subRepo = subRepo;
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
    }

    public Subscription subscribe(Long eventId, Long userId) {
        Subscription s = new Subscription();
        s.setEvent(eventRepo.findById(eventId).orElseThrow());
        s.setUser(userRepo.findById(userId).orElseThrow());
        return subRepo.save(s);
    }

    public List<Subscription> getSubscriptions(Long eventId) {
        return subRepo.findByEventId(eventId);
    }
}
