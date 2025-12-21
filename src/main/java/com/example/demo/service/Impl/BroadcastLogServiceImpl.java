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
    public BroadcastLog save(BroadcastLog log) {
        return broadcastLogRepository.save(log);
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        return broadcastLogRepository.findByEventUpdateId(updateId);
    }
}
