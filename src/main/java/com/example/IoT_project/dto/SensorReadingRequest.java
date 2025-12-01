package com.example.IoT_project.dto;

import lombok.Data;

@Data
public class SensorReadingRequest {
    private double temperature;
    private double humidity;
    private Long deviceId;
}
