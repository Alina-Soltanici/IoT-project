package com.example.IoT_project.service;

import com.example.IoT_project.dto.SensorDeviceRequest;
import com.example.IoT_project.dto.SensorDeviceResponse;
import com.example.IoT_project.entity.SensorDevice;

import java.util.List;

public interface SensorDeviceService {
    SensorDeviceResponse createDevice(SensorDeviceRequest request);
    List<SensorDeviceResponse> getAllDevices();
    SensorDeviceResponse getDeviceById(Long id);
    SensorDeviceResponse updateDevice(Long id, SensorDeviceRequest request);
    void deleteDevice(Long id);
    SensorDevice getDeviceEntityById(Long id);
}
