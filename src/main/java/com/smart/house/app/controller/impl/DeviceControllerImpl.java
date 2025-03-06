package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.DeviceController;
import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;
import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.service.SmartDeviceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/smart-device")
public class DeviceControllerImpl implements DeviceController {

    private final SmartDeviceService smartDeviceService;

    @GetMapping(value = "name")
    @Override
    public ResponseEntity<?> getSmartDevice(@RequestParam String name) {
        try {
            SmartDeviceResponseDto response = smartDeviceService.getSmartDevice(name);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping
    @Override
    public ResponseEntity<?> createSmartDevice(SmartDeviceRequestDto smartDeviceRequestDto) {
        try {
            SmartDeviceResponseDto response = smartDeviceService.createSmartDevice(smartDeviceRequestDto);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteSmartDevice(Long id) {
        smartDeviceService.deleteSmartDevice(id);
    }
}
