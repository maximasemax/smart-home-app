package com.smart.house.app.controller;

import com.smart.house.app.dto.HouseSpec.HouseSpecRequestDto;
import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;

public interface HouseSpecController {

    HouseSpecResponseDto getHouseSpec(Long id) throws CustomEntityNotFoundException;

    HouseSpecResponseDto createHouseSpec(HouseSpecRequestDto houseSpecRequestDto);

    HouseSpecResponseDto changeHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id) throws CustomEntityNotFoundException;

    void deleteHouseSpec(Long id);
}
