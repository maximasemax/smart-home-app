package com.smart.house.app.service;

import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.entity.SmartDeviceType;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.repository.SmartDeviceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmartDeviceTypeService {

    private final SmartDeviceTypeRepository smartDeviceTypeRepository;

    public SmartDeviceTypeResponseDto getSmartDeviceType(Long id) throws CustomEntityNotFoundException {
        Optional<SmartDeviceType> smartDeviceTypeOptional = smartDeviceTypeRepository.findById(id);
        if (smartDeviceTypeOptional.isPresent()) {
            SmartDeviceType smartDeviceTypeEntity = smartDeviceTypeOptional.get();
            return SmartDeviceTypeResponseDto.builder()
                    .type(smartDeviceTypeEntity.getType())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("Smart device type not found");
        }
    }


    public SmartDeviceTypeResponseDto createSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto) {
        SmartDeviceType smartDeviceTypeEntity = new SmartDeviceType();
        smartDeviceTypeEntity.setType(smartDeviceTypeRequestDto.getType());
        SmartDeviceType result = smartDeviceTypeRepository.save(smartDeviceTypeEntity);
        return SmartDeviceTypeResponseDto.builder()
                .type(smartDeviceTypeEntity.getType())
                .build();
    }

    public SmartDeviceTypeResponseDto changeSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto, Long id) throws CustomEntityNotFoundException {
        Optional<SmartDeviceType> smartDeviceTypeOptional = smartDeviceTypeRepository.findById(id);
        if (smartDeviceTypeOptional.isPresent()) {
            SmartDeviceType smartDeviceTypeEntity = smartDeviceTypeOptional.get();
            smartDeviceTypeEntity.setType(smartDeviceTypeRequestDto.getType());
            SmartDeviceType result = smartDeviceTypeRepository.save(smartDeviceTypeEntity);
            return SmartDeviceTypeResponseDto.builder()
                    .type(smartDeviceTypeEntity.getType())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("Smart device type not found");
        }
    }

    public void deleteSmartDeviceType(Long id) throws CustomEntityNotFoundException {
        Optional<SmartDeviceType> smartDeviceTypeOptional = smartDeviceTypeRepository.findById(id);
        if (smartDeviceTypeOptional.isPresent()) {
            SmartDeviceType smartDeviceTypeEntity = smartDeviceTypeOptional.get();
            smartDeviceTypeRepository.delete(smartDeviceTypeEntity);
        } else {
            throw new CustomEntityNotFoundException("Smart device type not found");
        }
    }
}

