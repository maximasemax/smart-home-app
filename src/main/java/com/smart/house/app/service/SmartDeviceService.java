package com.smart.house.app.service;

import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.entity.Material;
import com.smart.house.app.entity.SmartDevice;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmartDeviceService {

    private final DeviceRepository deviceRepository;


    public SmartDeviceResponseDto getSmartDevice(String name) throws CustomEntityNotFoundException {
        Optional<SmartDevice> smartDeviceOptional = deviceRepository.findByName(name);
        if (smartDeviceOptional.isPresent()) {
            SmartDevice smartDeviceEntity = smartDeviceOptional.get();
            return SmartDeviceResponseDto.builder()
                    .name(smartDeviceEntity.getName())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("Smart device not found");
        }
    }

    public SmartDeviceResponseDto createSmartDevice(SmartDeviceRequestDto smartDeviceRequestDto) {
        SmartDevice smartDeviceEntity = new SmartDevice();
        smartDeviceEntity.setName(smartDeviceRequestDto.getName());
        smartDeviceEntity.setSmartDeviceType(smartDeviceRequestDto.getSmartDeviceType());
        SmartDevice result = deviceRepository.save(smartDeviceEntity);
        return SmartDeviceResponseDto.builder()
                .name(result.getName())
                .build();
    }


    public void deleteSmartDevice(Long id) throws CustomEntityNotFoundException {
        Optional<SmartDevice> smartDeviceOptional = deviceRepository.findById(id);
        if (smartDeviceOptional.isPresent()) {
            SmartDevice smartDeviceEntity = smartDeviceOptional.get();
            deviceRepository.delete(smartDeviceEntity);
        } else {
            throw new CustomEntityNotFoundException("Smart device not found");
        }
    }
}
