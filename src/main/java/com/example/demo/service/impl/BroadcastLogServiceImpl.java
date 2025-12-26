package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
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
        // Implementation for broadcast trigger
        List<BroadcastLog> logs = broadcastLogRepository.findByEventUpdateId(eventUpdateId);
        // Process broadcast
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long eventUpdateId) {
        return broadcastLogRepository.findByEventUpdateId(eventUpdateId);
    }

    @Override
    public void recordDelivery(Long eventUpdateId, Long userId, boolean success) {
        List<BroadcastLog> logs = broadcastLogRepository.findByEventUpdateId(eventUpdateId);
        for (BroadcastLog log : logs) {
            if (log.getSubscriber().getId().equals(userId)) {
                log.setDeliveryStatus(success ? com.example.demo.entity.DeliveryStatus.DELIVERED : com.example.demo.entity.DeliveryStatus.FAILED);
                broadcastLogRepository.save(log);
                break;
            }
        }
    }
}
