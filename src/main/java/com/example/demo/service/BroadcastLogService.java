package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastLogService {
    List<BroadcastLog> getLogsForUpdate(Long updateId);
}
