package com.smart.house.app.service;

import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.dto.user.UserRequestDto;
import com.smart.house.app.dto.user.UserResponseDto;
import com.smart.house.app.entity.SmartDeviceType;
import com.smart.house.app.entity.User;
import com.smart.house.app.repository.SmartDeviceTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmartDeviceTypeService {

    private final SmartDeviceTypeRepository smartDeviceTypeRepository;

    public SmartDeviceTypeResponseDto getSmartDeviceType(Long id){
        SmartDeviceType smartDeviceTypeEntity = smartDeviceTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("smartDeviceType not found"));
        return SmartDeviceTypeResponseDto.builder()
                .type(smartDeviceTypeEntity.getType())
                .build();
    }


    public SmartDeviceTypeResponseDto createSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto){
        SmartDeviceType smartDeviceTypeEntity = new SmartDeviceType();
        smartDeviceTypeEntity.setType(smartDeviceTypeRequestDto.getType());
        SmartDeviceType result = smartDeviceTypeRepository.save(smartDeviceTypeEntity);
        return SmartDeviceTypeResponseDto.builder()
                .type(smartDeviceTypeEntity.getType())
                .build();
    }

    public SmartDeviceTypeResponseDto changeSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto, Long id){
        SmartDeviceType smartDeviceTypeEntity = smartDeviceTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("smartDeviceType not found"));
        smartDeviceTypeEntity.setType(smartDeviceTypeRequestDto.getType());
        SmartDeviceType result = smartDeviceTypeRepository.save(smartDeviceTypeEntity);
        return SmartDeviceTypeResponseDto.builder()
                .type(smartDeviceTypeEntity.getType())
                .build();
    }

    public void deleteSmartDeviceType(Long id){
        SmartDeviceType smartDeviceTypeEntity = smartDeviceTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("smartDeviceType not found"));
        smartDeviceTypeRepository.delete(smartDeviceTypeEntity);
    }
}
