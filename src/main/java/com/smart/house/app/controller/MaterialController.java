package com.smart.house.app.controller;

import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface MaterialController {

    MaterialResponseDto getMaterial(String name);

    MaterialResponseDto createMaterial(@RequestBody MaterialRequestDto materialRequestDto);

    MaterialResponseDto changeCostMaterial(@RequestBody MaterialRequestDto materialRequestDto, Long id);

    MaterialResponseDto changeDescriptionMaterial(@RequestBody MaterialRequestDto materialRequestDto, Long id);

    void deleteMaterial(Long id);
}
