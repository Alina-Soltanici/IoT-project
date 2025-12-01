package com.example.IoT_project.mapper;

import com.example.IoT_project.dto.SensorDeviceRequest;
import com.example.IoT_project.dto.SensorDeviceResponse;
import com.example.IoT_project.entity.SensorDevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SensorDeviceMapper {
    private final SensorReadingMapper readingMapper;

    //dto to entity
    public SensorDevice toEntity(SensorDeviceRequest sensorDeviceRequest) {
        SensorDevice sensorDevice = new SensorDevice();
        sensorDevice.setSensorName(sensorDeviceRequest.getSensorName());
        sensorDevice.setLocation(sensorDeviceRequest.getLocation());
        return sensorDevice;
    }


    public SensorDeviceResponse toDto(SensorDevice device) {
        SensorDeviceResponse response = new SensorDeviceResponse();
        response.setId(device.getId());
        response.setSensorName(device.getSensorName());
        response.setLocation(device.getLocation());
        if (device.getReadings() != null) {
            response.setReadings(
                    device.getReadings().stream()
                            .map(readingMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        return response;
    }
}
