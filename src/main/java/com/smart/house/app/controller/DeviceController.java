package com.smart.house.app.controller;

import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface DeviceController {
    SmartDeviceResponseDto getSmartDevice(String name);

    SmartDeviceResponseDto createSmartDevice(@RequestBody SmartDeviceRequestDto smartDeviceRequestDto);

    void deleteSmartDevice(Long id);
}
