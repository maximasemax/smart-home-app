package com.smart.house.app.controller;

import com.smart.house.app.dto.materialType.MaterialTypeRequestDto;
import com.smart.house.app.dto.materialType.MaterialTypeResponseDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SmartDeviceTypeController {

    SmartDeviceTypeResponseDto getSmartDeviceType(Long id);

    SmartDeviceTypeResponseDto createSmartDeviceType(@RequestBody SmartDeviceTypeRequestDto smartDeviceTypeRequestDto);

    SmartDeviceTypeResponseDto changeSmartDeviceType(@RequestBody SmartDeviceTypeRequestDto smartDeviceTypeRequestDto, Long id);

    void deleteSmartDeviceType(Long id);
}
