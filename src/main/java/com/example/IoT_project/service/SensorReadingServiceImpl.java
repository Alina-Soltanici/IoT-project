package com.example.IoT_project.service;

import com.example.IoT_project.dto.SensorReadingRequest;
import com.example.IoT_project.dto.SensorReadingResponse;
import com.example.IoT_project.entity.SensorDevice;
import com.example.IoT_project.entity.SensorReading;
import com.example.IoT_project.mapper.SensorReadingMapper;
import com.example.IoT_project.repository.SensorReadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository readingRepository;
    private final SensorDeviceService deviceService;
    private final SensorReadingMapper sensorReadingMapper;

    @Override
    public SensorReadingResponse createReading(SensorReadingRequest request) {
        SensorDevice device = deviceService.getDeviceEntityById(request.getDeviceId());
        SensorReading reading = sensorReadingMapper.toEntity(request, device);
        SensorReading saved = readingRepository.save(reading);
        return sensorReadingMapper.toDto(saved);
    }

    @Override
    public List<SensorReadingResponse> getAllReadings() {
        return readingRepository.findAll().stream()
                .map(sensorReadingMapper::toDto)
                .toList();
    }

    @Override
    public SensorReadingResponse getReadingById(Long id) {
        SensorReading reading = readingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reading not found"));
        return sensorReadingMapper.toDto(reading);
    }

    @Override
    public List<SensorReadingResponse> getReadingsByDeviceId(Long deviceId) {
        deviceService.getDeviceById(deviceId);
        return readingRepository.findByDeviceId(deviceId).stream()
                .map(sensorReadingMapper::toDto)
                .toList();
    }

    @Override
    public SensorReadingResponse getLatestReadingByDeviceId(Long deviceId) {
        SensorReading reading = readingRepository
                .findFirstByDeviceIdOrderByLocalDateTimeDesc(deviceId)
                .orElseThrow(() -> new RuntimeException("No readings found for device"));
        return sensorReadingMapper.toDto(reading);
    }

    @Override
    public List<SensorReadingResponse> getReadingsByDeviceIdAndTimeRange(Long deviceId, LocalDateTime start, LocalDateTime end) {
        return readingRepository.findByDeviceIdAndLocalDateTimeBetween(deviceId, start, end)
                .stream()
                .map(sensorReadingMapper::toDto)
                .toList();
    }


    @Override
    public void deleteReading(Long id) {
        readingRepository.deleteById(id);
    }
}
