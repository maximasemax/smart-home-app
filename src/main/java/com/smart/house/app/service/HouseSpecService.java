package com.smart.house.app.service;

import com.smart.house.app.dto.HouseSpec.request.HouseSpecRequestDto;
import com.smart.house.app.dto.HouseSpec.response.HouseSpecResponseDto;
import com.smart.house.app.entity.HouseSpec;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.repository.HouseSpecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseSpecService {

    private final HouseSpecRepository houseSpecRepository;

    public HouseSpecResponseDto getHouseSpec(Long id) throws CustomEntityNotFoundException {
        Optional<HouseSpec> houseSpec = houseSpecRepository.findById(id);
        if (houseSpec.isPresent()) {
            HouseSpec houseSpecEntity = houseSpec.get();
            return HouseSpecResponseDto.builder()
                    .floors(houseSpecEntity.getFloors())
                    .totalCost(houseSpecEntity.getTotalCost())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("House not found");
        }
    }

    public HouseSpecResponseDto changeHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id) throws CustomEntityNotFoundException {
        Optional<HouseSpec> houseSpec = houseSpecRepository.findById(id);
        if (houseSpec.isPresent()) {
            HouseSpec houseSpecEntity = houseSpec.get();
            houseSpecEntity.setFloors(houseSpecRequestDto.getFloors());
            houseSpecEntity.setTotalCost(houseSpecRequestDto.getTotalCost());
            HouseSpec result = houseSpecRepository.save(houseSpecEntity);
            return HouseSpecResponseDto.builder()
                    .floors(result.getFloors())
                    .totalCost(result.getTotalCost())
                    .build();
        }
        throw new CustomEntityNotFoundException("House not found");

    }

    public HouseSpecResponseDto createHouseSpec(HouseSpecRequestDto houseSpecRequestDto) {
        HouseSpec houseSpecEntity = new HouseSpec();
        houseSpecEntity.setFloors(houseSpecRequestDto.getFloors());
        houseSpecEntity.setTotalCost(houseSpecRequestDto.getTotalCost());
        HouseSpec result = houseSpecRepository.save(houseSpecEntity);
        return HouseSpecResponseDto.builder()
                .floors(result.getFloors())
                .totalCost(result.getTotalCost())
                .build();
    }

    public void deleteHouseSpec(Long id) throws CustomEntityNotFoundException {
        HouseSpec houseSpecEntity = houseSpecRepository.findById(id)
                .orElseThrow(() -> new CustomEntityNotFoundException("House not found"));
        houseSpecRepository.delete(houseSpecEntity);
    }

}
