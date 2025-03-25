package com.smart.house.app.controller;


import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface DeviceController {
    ResponseEntity<?> getSmartDevice(String name);

    ResponseEntity<?> createSmartDevice(@RequestBody SmartDeviceRequestDto smartDeviceRequestDto);

    ResponseEntity<?> getAllSmartDevices();

    void deleteSmartDevice(Long id) throws CustomEntityNotFoundException;
}
