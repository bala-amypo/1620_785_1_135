package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastLogService {
    void triggerBroadcast(Long eventUpdateId);
    List<BroadcastLog> getLogsForUpdate(Long eventUpdateId);
    void recordDelivery(Long eventUpdateId, Long userId, boolean success);
}
