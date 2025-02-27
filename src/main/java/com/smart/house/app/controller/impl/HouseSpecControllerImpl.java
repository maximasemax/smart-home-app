package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.HouseSpecController;
import com.smart.house.app.dto.HouseSpec.HouseSpecRequestDto;
import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;
import com.smart.house.app.service.HouseSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/house-spec")
public class HouseSpecControllerImpl implements HouseSpecController {

    private final HouseSpecService houseSpecService;

    @Override
    public HouseSpecResponseDto getHouseSpec(Long id) {
        return null;
    }

    @Override
    public HouseSpecResponseDto createHouseSpec(HouseSpecRequestDto houseSpecRequestDto) {
        return null;
    }

    @Override
    public HouseSpecResponseDto changeHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id) {
        return null;
    }

    @Override
    public void deleteHouseSpec(Long id) {

    }
}
