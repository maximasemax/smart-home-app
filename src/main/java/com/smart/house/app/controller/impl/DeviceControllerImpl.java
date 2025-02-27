package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.DeviceController;
import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.service.SmartDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/smart-device")
public class DeviceControllerImpl implements DeviceController {

    private final SmartDeviceService smartDeviceService;

    @GetMapping(value = "name")
    @Override
    public SmartDeviceResponseDto getSmartDevice(String name) {
        return smartDeviceService.getSmartDevice(name);
    }

    @PostMapping
    @Override
    public SmartDeviceResponseDto createSmartDevice(SmartDeviceRequestDto smartDeviceRequestDto) {
        return smartDeviceService.createSmartDevice(smartDeviceRequestDto);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteSmartDevice(Long id) {
        smartDeviceService.deleteSmartDevice(id);
    }
}
