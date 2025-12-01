package com.example.IoT_project.controller;

import com.example.IoT_project.dto.SensorDeviceRequest;
import com.example.IoT_project.dto.SensorDeviceResponse;
import com.example.IoT_project.service.SensorDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class SensorDeviceController {

    private final SensorDeviceService deviceService;

    @PostMapping
    public ResponseEntity<SensorDeviceResponse> createDevice(@RequestBody SensorDeviceRequest request) {
        return ResponseEntity.ok(deviceService.createDevice(request));
    }

    @GetMapping
    public ResponseEntity<List<SensorDeviceResponse>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorDeviceResponse> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.getDeviceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorDeviceResponse> updateDevice(
            @PathVariable Long id,
            @RequestBody SensorDeviceRequest request
    ) {
        return ResponseEntity.ok(deviceService.updateDevice(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
