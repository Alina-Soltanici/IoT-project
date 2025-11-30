package com.example.IoT_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class SensorReading {
    @Id
    @GeneratedValue()
    private Long id;
    private double temperature;
    private double humidity;
    private LocalDateTime localDateTime;

    @ManyToOne
    private SensorDevice device;
}
