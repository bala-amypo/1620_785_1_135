package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.service.BroadcastLogService;
import com.example.demo.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastLogService broadcastLogService;

    public BroadcastServiceImpl(BroadcastLogService broadcastLogService) {
        this.broadcastLogService = broadcastLogService;
    }

    @Override
    public void broadcastUpdate(Long eventUpdateId) {
        broadcastLogService.triggerBroadcast(eventUpdateId);
    }

    @Override
    public void recordDelivery(Long eventUpdateId, Long userId, boolean success) {
        broadcastLogService.recordDelivery(eventUpdateId, userId, success);
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long eventUpdateId) {
        return broadcastLogService.getLogsForUpdate(eventUpdateId);
    }
}
