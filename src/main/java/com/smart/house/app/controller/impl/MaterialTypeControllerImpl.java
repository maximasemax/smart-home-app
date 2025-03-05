package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.MaterialTypeController;
import com.smart.house.app.dto.material_type.MaterialTypeRequestDto;
import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import com.smart.house.app.service.MaterialTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material-type")
public class MaterialTypeControllerImpl implements MaterialTypeController {

    private final MaterialTypeService materialTypeService;

    @GetMapping(value = "id")
    @Override
    public MaterialTypeResponseDto getMaterialType(Long id) {
        return materialTypeService.getMaterialType(id);
    }

    @PostMapping
    @Override
    public MaterialTypeResponseDto createMaterialType(MaterialTypeRequestDto materialTypeRequestDto) {
        return materialTypeService.createMaterialType(materialTypeRequestDto);
    }

    @PutMapping
    @Override
    public MaterialTypeResponseDto changeMaterialType(MaterialTypeRequestDto materialTypeRequestDto, Long id) {
        return materialTypeService.changeMaterialType(materialTypeRequestDto, id);
    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteMaterialType(Long id) {
        materialTypeService.deleteMaterialType(id);
    }
}
