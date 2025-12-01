package com.example.IoT_project.repository;

import com.example.IoT_project.entity.SensorDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDeviceRepository extends JpaRepository<SensorDevice, Long> {
}

