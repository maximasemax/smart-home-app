package com.smart.house.app.controller;

import com.smart.house.app.dto.HouseSpec.HouseSpecRequestDto;
import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;

public interface HouseSpecController {

    HouseSpecResponseDto getHouseSpec(Long id);

    HouseSpecResponseDto createHouseSpec(HouseSpecRequestDto houseSpecRequestDto);

    HouseSpecResponseDto changeHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id);

    void deleteHouseSpec(Long id);
}
