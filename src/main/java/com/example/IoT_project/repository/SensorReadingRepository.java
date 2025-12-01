package com.example.IoT_project.repository;

import com.example.IoT_project.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    List<SensorReading> findByDeviceId(Long deviceId);

    Optional<SensorReading> findFirstByDeviceIdOrderByLocalDateTimeDesc(Long deviceId);

    List<SensorReading> findByDeviceIdAndLocalDateTimeBetween(
            Long deviceId,
            LocalDateTime start,
            LocalDateTime end
    );
}
