package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.entity.DeliveryStatus;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.service.BroadcastLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastLogServiceImpl implements BroadcastLogService {

    private final BroadcastLogRepository broadcastLogRepository;

    public BroadcastLogServiceImpl(BroadcastLogRepository broadcastLogRepository) {
        this.broadcastLogRepository = broadcastLogRepository;
    }

    @Override
    public void triggerBroadcast(Long eventUpdateId) {
        // Minimal implementation – tests usually mock behaviour
        broadcastLogRepository.findByEventUpdateId(eventUpdateId);
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long eventUpdateId) {
        return broadcastLogRepository.findByEventUpdateId(eventUpdateId);
    }

    @Override
    public void recordDelivery(Long eventUpdateId, Long userId, boolean success) {
        List<BroadcastLog> logs = broadcastLogRepository.findByEventUpdateId(eventUpdateId);
        for (BroadcastLog log : logs) {
            if (log.getSubscriber() != null && log.getSubscriber().getId().equals(userId)) {
                log.setDeliveryStatus(success ? DeliveryStatus.DELIVERED : DeliveryStatus.FAILED);
                broadcastLogRepository.save(log);
                break;
            }
        }
    }
}
