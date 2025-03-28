package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.DeviceController;
import com.smart.house.app.dto.device.request.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.response.SmartDeviceResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.service.SmartDeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/smart-device")
@Log4j2
public class DeviceControllerImpl implements DeviceController {

    private final SmartDeviceService smartDeviceService;

    @GetMapping(value = "name")
    @Override
    public ResponseEntity<?> getSmartDevice(@RequestParam String name) {
        try {
            SmartDeviceResponseDto response = smartDeviceService.getSmartDevice(name);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Smart device not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }
    @PostMapping
    @Override
    public ResponseEntity<?> createSmartDevice(SmartDeviceRequestDto smartDeviceRequestDto) {
        try {
            SmartDeviceResponseDto response = smartDeviceService.createSmartDevice(smartDeviceRequestDto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAllSmartDevices() {
        log.info("Получен запрос на получение всех устройств");
        try {
            List<SmartDeviceResponseDto> responseList = smartDeviceService.getAllSmartDevices();
            return ResponseEntity.ok(responseList);
        } catch (Exception e) {
            log.error("Ошибка при получении : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteSmartDevice(Long id) throws CustomEntityNotFoundException {
        smartDeviceService.deleteSmartDevice(id);
    }
}
