package com.example.IoT_project.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorReadingResponse {
    private Long id;
    private double temperature;
    private double humidity;
    private LocalDateTime localDateTime;
    private Long deviceId;
}
