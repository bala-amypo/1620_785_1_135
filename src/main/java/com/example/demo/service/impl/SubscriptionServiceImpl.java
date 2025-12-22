package com.example.demo.service.impl;

import com.example.demo.entity.Channel;
import com.example.demo.entity.Subscription;
import com.example.demo.repository.ChannelRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final ChannelRepository channelRepository;
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(ChannelRepository channelRepository,
                                   SubscriptionRepository subscriptionRepository) {
        this.channelRepository = channelRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription subscribe(Long channelId, String userEmail) {
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new RuntimeException("Channel not found"));

        Subscription subscription = new Subscription(channel, userEmail);
        return subscriptionRepository.save(subscription);
    }
}
