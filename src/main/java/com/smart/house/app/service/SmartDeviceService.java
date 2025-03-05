package com.smart.house.app.service;

import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.entity.Material;
import com.smart.house.app.entity.SmartDevice;
import com.smart.house.app.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmartDeviceService {

    private final DeviceRepository deviceRepository;


    public SmartDeviceResponseDto getSmartDevice(String name){
        SmartDevice smartDeviceEntity = deviceRepository.findByName(name).orElseThrow(() ->
                new EntityNotFoundException("Device not found"));
        return SmartDeviceResponseDto.builder()
                .name(smartDeviceEntity.getName())
                .build();

    }

    public SmartDeviceResponseDto createSmartDevice(SmartDeviceRequestDto smartDeviceRequestDto){
        SmartDevice smartDeviceEntity = new SmartDevice();
        smartDeviceEntity.setName(smartDeviceRequestDto.getName());
        smartDeviceEntity.setSmartDeviceType(smartDeviceRequestDto.getSmartDeviceType());
        SmartDevice result = deviceRepository.save(smartDeviceEntity);
        return SmartDeviceResponseDto.builder()
                .name(result.getName())
                .build();
    }



    public void deleteSmartDevice(Long id) {
        SmartDevice smartDeviceEntity = deviceRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Device not found"));
        deviceRepository.delete(smartDeviceEntity);
    }
}
