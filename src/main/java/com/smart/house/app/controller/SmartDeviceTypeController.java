package com.smart.house.app.controller;

import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SmartDeviceTypeController {

    ResponseEntity<?> getSmartDeviceType(Long id);

    ResponseEntity<?> createSmartDeviceType(@RequestBody SmartDeviceTypeRequestDto smartDeviceTypeRequestDto);

    ResponseEntity<?> editSmartDeviceType(@RequestBody SmartDeviceTypeRequestDto smartDeviceTypeRequestDto, Long id);

    ResponseEntity<?> getAllSmartDeviceTypes();

    void deleteSmartDeviceType(Long id) throws CustomEntityNotFoundException;

}
