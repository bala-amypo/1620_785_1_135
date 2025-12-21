package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.service.BroadcastLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastLogServiceImpl implements BroadcastLogService {

    private final BroadcastLogRepository repo;

    public BroadcastLogServiceImpl(BroadcastLogRepository repo) {
        this.repo = repo;
    }

    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        return repo.findByEventUpdateId(updateId);
    }
}
