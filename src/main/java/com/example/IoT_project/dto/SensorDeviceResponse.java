// SensorDeviceResponse.java
package com.example.IoT_project.dto;

import lombok.Data;
import java.util.List;

@Data
public class SensorDeviceResponse {
    private Long id;
    private String sensorName;
    private String location;
    private List<SensorReadingResponse> readings;
}