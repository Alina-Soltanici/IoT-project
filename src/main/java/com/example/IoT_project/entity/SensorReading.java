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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double temperature;
    private double humidity;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @ManyToOne
    private SensorDevice device;
}
