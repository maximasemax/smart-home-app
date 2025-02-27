package com.smart.house.app.controller.impl;


import com.smart.house.app.controller.MaterialController;
import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material")
public class MaterialControllerImpl implements MaterialController {

    private final MaterialService materialService;

    @GetMapping(value = "name")
    @Override
    public MaterialResponseDto getMaterial(String name) {
        return materialService.getMaterial(name);
    }

    @PostMapping
    @Override
    public MaterialResponseDto createMaterial(MaterialRequestDto materialRequestDto) {
        return materialService.createMaterial(materialRequestDto);
    }

    @PutMapping(value = "change_cost")
    @Override
    public MaterialResponseDto changeCostMaterial(MaterialRequestDto materialRequestDto, Long id) {
        return materialService.changePriceMaterial(id, materialRequestDto);
    }

    @PutMapping(value = "change_description")
    @Override
    public MaterialResponseDto changeDescriptionMaterial(MaterialRequestDto materialRequestDto, Long id) {
        return materialService.changeDescriptionMaterial(id, materialRequestDto);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteMaterial(Long id) {
        materialService.deleteMaterial(id);
    }

}
