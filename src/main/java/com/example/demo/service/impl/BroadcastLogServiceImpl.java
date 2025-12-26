package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.entity.DeliveryStatus;
import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastLogServiceImpl implements BroadcastService {
    private final EventUpdateRepository eventUpdateRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final BroadcastLogRepository broadcastLogRepository;

    public BroadcastServiceImpl(EventUpdateRepository eventUpdateRepository,
                              SubscriptionRepository subscriptionRepository,
                              BroadcastLogRepository broadcastLogRepository) {
        this.eventUpdateRepository = eventUpdateRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.broadcastLogRepository = broadcastLogRepository;
    }

    @Override
    public void broadcastUpdate(Long eventUpdateId) {
        EventUpdate update = eventUpdateRepository.findById(eventUpdateId)
            .orElseThrow(() -> new RuntimeException("EventUpdate not found"));
        
        List<com.example.demo.entity.Subscription> subscriptions = 
            subscriptionRepository.findByEventId(update.getEvent().getId());
        
        for (com.example.demo.entity.Subscription sub : subscriptions) {
            BroadcastLog log = new BroadcastLog();
            log.setEventUpdate(update);
            log.setSubscriber(sub.getUser());
            broadcastLogRepository.save(log);
        }
    }

    @Override
    public void recordDelivery(Long eventUpdateId, Long userId, boolean success) {
        List<BroadcastLog> logs = broadcastLogRepository.findByEventUpdateId(eventUpdateId);
        for (BroadcastLog log : logs) {
            if (log.getSubscriber().getId().equals(userId)) {
                log.setDeliveryStatus(success ? DeliveryStatus.DELIVERED : DeliveryStatus.FAILED);
                broadcastLogRepository.save(log);
                break;
            }
        }
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long eventUpdateId) {
        return broadcastLogRepository.findByEventUpdateId(eventUpdateId);
    }
}
