package com.example.IoT_project.controller;

import com.example.IoT_project.dto.SensorReadingRequest;
import com.example.IoT_project.dto.SensorReadingResponse;
import com.example.IoT_project.service.SensorReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/readings")
@RequiredArgsConstructor
public class SensorReadingController {

    private final SensorReadingService readingService;


    @PostMapping
    public ResponseEntity<SensorReadingResponse> createReading(@RequestBody SensorReadingRequest request) {
        return ResponseEntity.ok(readingService.createReading(request));
    }


    @GetMapping
    public ResponseEntity<List<SensorReadingResponse>> getAllReadings() {
        return ResponseEntity.ok(readingService.getAllReadings());
    }


    @GetMapping("/{id}")
    public ResponseEntity<SensorReadingResponse> getReadingById(@PathVariable Long id) {
        return ResponseEntity.ok(readingService.getReadingById(id));
    }


    @GetMapping("/device/{deviceId}")
    public ResponseEntity<List<SensorReadingResponse>> getReadingsByDeviceId(@PathVariable Long deviceId) {
        return ResponseEntity.ok(readingService.getReadingsByDeviceId(deviceId));
    }


    @GetMapping("/device/{deviceId}/latest")
    public ResponseEntity<SensorReadingResponse> getLatestReadingByDeviceId(@PathVariable Long deviceId) {
        return ResponseEntity.ok(readingService.getLatestReadingByDeviceId(deviceId));
    }


    @GetMapping("/device/{deviceId}/range")
    public ResponseEntity<List<SensorReadingResponse>> getReadingsByDeviceIdAndTimeRange(
            @PathVariable Long deviceId,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return ResponseEntity.ok(readingService.getReadingsByDeviceIdAndTimeRange(deviceId, start, end));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReading(@PathVariable Long id) {
        readingService.deleteReading(id);
        return ResponseEntity.noContent().build();
    }
}
