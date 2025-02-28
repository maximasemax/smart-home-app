package com.smart.house.app.controller;

import com.smart.house.app.dto.material_type.MaterialTypeRequestDto;
import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface MaterialTypeController {

    MaterialTypeResponseDto getMaterialType(Long id);

    MaterialTypeResponseDto createMaterialType(@RequestBody MaterialTypeRequestDto materialTypeRequestDto);

    MaterialTypeResponseDto changeMaterialType(@RequestBody MaterialTypeRequestDto materialTypeRequestDto, Long id);

    void deleteMaterialType(Long id);
}
