package com.example.IoT_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class SensorDevice {
    private Long id;
    private String sensorName;
    private String location;

    @OneToMany(mappedBy = "device")
    private List<SensorReading> readings;
}
