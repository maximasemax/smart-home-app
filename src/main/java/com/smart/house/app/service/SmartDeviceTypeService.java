package com.smart.house.app.service;

import com.smart.house.app.dto.smartDeviceType.request.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.response.SmartDeviceTypeResponseDto;
import com.smart.house.app.entity.SmartDeviceType;
import com.smart.house.app.exception.CustomEntityNotFoundException;


import com.smart.house.app.mapper.SmartDeviceTypeMapper;
import com.smart.house.app.repository.SmartDeviceTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmartDeviceTypeService {

    private final SmartDeviceTypeRepository smartDeviceTypeRepository;
    private final SmartDeviceTypeMapper smartDeviceTypeMapper;


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

    public List<SmartDeviceTypeResponseDto> getAllSmartDeviceTypes() {
        log.info("Попытка сходить в базу");
        List<SmartDeviceType> smartDeviceTypeLists = smartDeviceTypeRepository.findAll();
        log.info("Попытка маппинга");
        return smartDeviceTypeLists.stream()
                .map(smartDeviceTypeMapper::toDto)
                .collect(Collectors.toList());
    }
}

