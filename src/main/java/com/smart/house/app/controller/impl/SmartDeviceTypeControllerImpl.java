package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.SmartDeviceTypeController;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.service.SmartDeviceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smart-device-type")
public class SmartDeviceTypeControllerImpl implements SmartDeviceTypeController {

    private final SmartDeviceTypeService smartDeviceTypeService;

    @GetMapping(value = "id")
    @Override
    public SmartDeviceTypeResponseDto getSmartDeviceType(Long id) {
        return smartDeviceTypeService.getSmartDeviceType(id);
    }

    @PostMapping
    @Override
    public SmartDeviceTypeResponseDto createSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto) {
        return smartDeviceTypeService.createSmartDeviceType(smartDeviceTypeRequestDto);
    }

    @PutMapping
    @Override
    public SmartDeviceTypeResponseDto changeSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto, Long id) {
        return smartDeviceTypeService.changeSmartDeviceType(smartDeviceTypeRequestDto, id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteSmartDeviceType(Long id) {
        smartDeviceTypeService.deleteSmartDeviceType(id);
    }
}
