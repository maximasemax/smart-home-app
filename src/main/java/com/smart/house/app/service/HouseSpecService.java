package com.smart.house.app.service;

import com.smart.house.app.dto.HouseSpec.HouseSpecRequestDto;
import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;
import com.smart.house.app.entity.HouseSpec;
import com.smart.house.app.repository.HouseSpecRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseSpecService {

    private final HouseSpecRepository houseSpecRepository;

    public HouseSpecResponseDto getHouseSpec(Long id) {
        HouseSpec houseSpecEntity = houseSpecRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("House not found"));
        return HouseSpecResponseDto.builder()
                .floors(houseSpecEntity.getFloors())
                .totalCost(houseSpecEntity.getTotalCost())
                .build();

    }

    public HouseSpecResponseDto changeHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id){
        HouseSpec houseSpecEntity = houseSpecRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("House not found"));
        houseSpecEntity.setFloors(houseSpecRequestDto.getFloors());
        houseSpecEntity.setTotalCost(houseSpecRequestDto.getTotalCost());
        HouseSpec result = houseSpecRepository.save(houseSpecEntity);
        return HouseSpecResponseDto.builder()
                .floors(result.getFloors())
                .totalCost(result.getTotalCost())
                .build();
    }

    public HouseSpecResponseDto createHouseSpec(HouseSpecRequestDto houseSpecRequestDto){
        HouseSpec houseSpecEntity = new HouseSpec();
        houseSpecEntity.setFloors(houseSpecRequestDto.getFloors());
        houseSpecEntity.setTotalCost(houseSpecRequestDto.getTotalCost());
        HouseSpec result = houseSpecRepository.save(houseSpecEntity);
        return HouseSpecResponseDto.builder()
                .floors(result.getFloors())
                .totalCost(result.getTotalCost())
                .build();
    }

    public void deleteHouseSpec(Long id){
        houseSpecRepository.deleteById(id);
    }

}
