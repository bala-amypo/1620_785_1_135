package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastLogService {

    /**
     * Trigger a broadcast for a given event update.
     *
     * The tests will mock this interface; they only care that
     * the method exists with this signature.
     */
    void broadcastUpdate(Long eventUpdateId);

    /**
     * Record delivery status for a specific user/subscriber
     * for a given event update.
     */
    void recordDelivery(Long eventUpdateId, Long userId, boolean success);

    /**
     * Return all broadcast logs for a given event update.
     */
    List<BroadcastLog> getLogsForUpdate(Long eventUpdateId);
}
