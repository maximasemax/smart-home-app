package com.smart.house.app.controller;

import com.smart.house.app.dto.materialType.MaterialTypeRequestDto;
import com.smart.house.app.dto.materialType.MaterialTypeResponseDto;
import com.smart.house.app.dto.user.UserRequestDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface MaterialTypeController {

    MaterialTypeResponseDto getMaterialType(Long id);

    MaterialTypeResponseDto createMaterialType(@RequestBody MaterialTypeRequestDto materialTypeRequestDto);

    MaterialTypeResponseDto changeMaterialType(@RequestBody MaterialTypeRequestDto materialTypeRequestDto, Long id);

    void deleteMaterialType(Long id);
}
