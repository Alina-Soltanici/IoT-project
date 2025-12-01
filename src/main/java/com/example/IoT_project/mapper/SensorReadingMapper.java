package com.example.IoT_project.mapper;

import com.example.IoT_project.dto.SensorReadingRequest;
import com.example.IoT_project.dto.SensorReadingResponse;
import com.example.IoT_project.entity.SensorDevice;
import com.example.IoT_project.entity.SensorReading;
import org.springframework.stereotype.Component;

@Component
public class SensorReadingMapper {
    //dto - to entity
    public SensorReading toEntity(SensorReadingRequest sensorReadingRequest, SensorDevice sensorDevice) {
        SensorReading sensorReading = new SensorReading();
        sensorReading.setTemperature(sensorReadingRequest.getTemperature());
        sensorReading.setHumidity(sensorReadingRequest.getHumidity());
        sensorReading.setDevice(sensorDevice);
        return sensorReading;
    }

    //SensorReading entity -> dto
    public SensorReadingResponse toDto(SensorReading sensorReading) {
        SensorReadingResponse response = new SensorReadingResponse();
        response.setId(sensorReading.getId());
        response.setTemperature(sensorReading.getTemperature());
        response.setHumidity(sensorReading.getHumidity());
        response.setLocalDateTime(sensorReading.getLocalDateTime());
        response.setDeviceId(sensorReading.getDevice() !=null? sensorReading.getDevice().getId() : null);
        return response;
    }

}
