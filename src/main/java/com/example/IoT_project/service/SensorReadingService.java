package com.example.IoT_project.service;

import com.example.IoT_project.dto.SensorReadingRequest;
import com.example.IoT_project.dto.SensorReadingResponse;
import java.time.LocalDateTime;
import java.util.List;

public interface SensorReadingService {
    SensorReadingResponse createReading(SensorReadingRequest request);
    List<SensorReadingResponse> getAllReadings();
    SensorReadingResponse getReadingById(Long id);
    List<SensorReadingResponse> getReadingsByDeviceId(Long deviceId);
    SensorReadingResponse getLatestReadingByDeviceId(Long deviceId);
    List<SensorReadingResponse> getReadingsByDeviceIdAndTimeRange(Long deviceId, LocalDateTime start, LocalDateTime end);
    void deleteReading(Long id);
}
