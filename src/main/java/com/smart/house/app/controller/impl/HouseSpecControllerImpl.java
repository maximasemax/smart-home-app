package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.HouseSpecController;
import com.smart.house.app.dto.HouseSpec.HouseSpecRequestDto;
import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.service.HouseSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/house-spec")
public class HouseSpecControllerImpl implements HouseSpecController {

    private final HouseSpecService houseSpecService;

    @GetMapping(value = "id")
    @Override
    public HouseSpecResponseDto getHouseSpec(Long id) throws CustomEntityNotFoundException {
        return houseSpecService.getHouseSpec(id);
    }

    @PostMapping
    @Override
    public HouseSpecResponseDto createHouseSpec(HouseSpecRequestDto houseSpecRequestDto) {
        return houseSpecService.createHouseSpec(houseSpecRequestDto);
    }
    @PutMapping
    @Override
    public HouseSpecResponseDto changeHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id) throws CustomEntityNotFoundException {
        return houseSpecService.changeHouseSpec(houseSpecRequestDto, id);

    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteHouseSpec(Long id) {
        houseSpecService.deleteHouseSpec(id);
    }
}
