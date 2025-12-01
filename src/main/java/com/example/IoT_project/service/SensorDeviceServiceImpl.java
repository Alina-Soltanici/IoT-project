package com.example.IoT_project.service;

import com.example.IoT_project.dto.SensorDeviceRequest;
import com.example.IoT_project.dto.SensorDeviceResponse;
import com.example.IoT_project.entity.SensorDevice;
import com.example.IoT_project.mapper.SensorDeviceMapper;
import com.example.IoT_project.repository.SensorDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorDeviceServiceImpl implements SensorDeviceService {

    private final SensorDeviceRepository deviceRepository;
    private final SensorDeviceMapper deviceMapper;

    @Override
    public SensorDeviceResponse createDevice(SensorDeviceRequest request) {
        SensorDevice device = deviceMapper.toEntity(request);
        SensorDevice saved = deviceRepository.save(device);
        return deviceMapper.toDto(saved);
    }

    @Override
    public List<SensorDeviceResponse> getAllDevices() {
        return deviceRepository.findAll().stream()
                .map(deviceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SensorDeviceResponse getDeviceById(Long id) {
        SensorDevice device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        return deviceMapper.toDto(device);
    }

    @Override
    public SensorDeviceResponse updateDevice(Long id, SensorDeviceRequest request) {
        SensorDevice existing = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        if (request.getSensorName() != null && !request.getSensorName().isBlank()) {
            existing.setSensorName(request.getSensorName());
        }

        if (request.getLocation() != null && !request.getLocation().isBlank()) {
            existing.setLocation(request.getLocation());
        }

        SensorDevice saved = deviceRepository.save(existing);
        return deviceMapper.toDto(saved);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public SensorDevice getDeviceEntityById(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }
}
