package com.example.demo.service;

public interface BroadcastLogService {
    void broadcastUpdate(Long eventUpdateId);
    void recordDelivery(Long eventUpdateId, Long userId, boolean success);
    List<BroadcastLog> getLogsForUpdate(Long eventUpdateId);
}
