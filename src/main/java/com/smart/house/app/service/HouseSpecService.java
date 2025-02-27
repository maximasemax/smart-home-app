package com.smart.house.app.service;

import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;
import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.entity.HouseSpec;
import com.smart.house.app.entity.SmartDevice;
import com.smart.house.app.repository.HouseSpecRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseSpecService {

    private final HouseSpecRepository houseSpecRepository;

    public HouseSpecResponseDto getHouseSpec(Long id){
        HouseSpec houseSpecEntity = houseSpecRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("House not found"));
        return HouseSpecResponseDto.builder()
                .floors()
                .build();

    }

    
}
