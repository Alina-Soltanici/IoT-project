package com.example.IoT_project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class SensorDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_device_gen")
    @SequenceGenerator(name = "sensor_device_gen", sequenceName = "device_sequence", allocationSize = 1)
    private Long id;
    private String sensorName;
    private String location;

    @OneToMany(mappedBy = "device")
    private List<SensorReading> readings;
}
