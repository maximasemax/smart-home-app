package com.smart.house.app.controller;

import com.smart.house.app.dto.HouseSpec.request.HouseSpecRequestDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import org.springframework.http.ResponseEntity;

public interface HouseSpecController {

    ResponseEntity<?> getHouseSpec(Long id) throws CustomEntityNotFoundException;

    ResponseEntity<?> createHouseSpec(HouseSpecRequestDto houseSpecRequestDto);

    ResponseEntity<?> editHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id)
            throws CustomEntityNotFoundException;

    void deleteHouseSpec(Long id) throws CustomEntityNotFoundException;
}
