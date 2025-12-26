package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastLogService {

    /**
     * Trigger a broadcast for a given event update.
     */
    void triggerBroadcast(Long eventUpdateId);

    /**
     * Return all broadcast logs for a given event update.
     */
    List<BroadcastLog> getLogsForUpdate(Long eventUpdateId);

    /**
     * Record delivery status for a specific user.
     */
    void recordDelivery(Long eventUpdateId, Long userId, boolean success);
}
