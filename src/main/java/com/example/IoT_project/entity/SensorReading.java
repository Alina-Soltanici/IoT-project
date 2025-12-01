package com.example.IoT_project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class SensorReading {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_reading_gen")
    @SequenceGenerator(name = "sensor_reading_gen", sequenceName = "sensor_reading_sequence", allocationSize = 1)
    private Long id;
    private double temperature;
    private double humidity;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToOne
    private SensorDevice device;
}
