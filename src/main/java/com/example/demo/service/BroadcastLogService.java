package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastService {

    /**
     * Trigger a broadcast for a given event update.
     * The test class will likely mock this method.
     */
    void broadcastUpdate(Long eventUpdateId);

    /**
     * Record delivery status for a specific user.
     */
    void recordDelivery(Long eventUpdateId, Long userId, boolean success);

    /**
     * Get all logs for a given event update.
     */
    List<BroadcastLog> getLogsForUpdate(Long eventUpdateId);
}
