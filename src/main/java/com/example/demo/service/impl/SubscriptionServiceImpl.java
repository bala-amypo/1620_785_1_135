package com.example.demo.service.impl;

import com.example.demo.entity.Channel;
import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.repository.ChannelRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;

    public SubscriptionServiceImpl(
            SubscriptionRepository subscriptionRepository,
            UserRepository userRepository,
            ChannelRepository channelRepository
    ) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void subscribe(Long userId, Long channelId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new RuntimeException("Channel not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setChannel(channel);

        subscriptionRepository.save(subscription);
    }

    @Override
    public void unsubscribe(Long userId, Long channelId) {
        subscriptionRepository.deleteByUserIdAndChannelId(userId, channelId);
    }
}
