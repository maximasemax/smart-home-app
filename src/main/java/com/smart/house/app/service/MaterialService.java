package com.smart.house.app.service;


import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.entity.Material;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.repository.MaterialRepository;
import com.smart.house.app.repository.MaterialTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialResponseDto getMaterial(String name) throws CustomEntityNotFoundException {
        Optional<Material> materialEntityOptional = materialRepository.findByName(name);
        if (materialEntityOptional.isPresent()) {
            Material materialEntity = materialEntityOptional.get();
            return MaterialResponseDto.builder()
                    .price(materialEntity.getPrice())
                    .name(materialEntity.getName())
                    .description(materialEntity.getDescription())
                    .materialType(materialEntity.getMaterialType())
                    .build();
        }
        else {
            throw new CustomEntityNotFoundException("Material not foud");
        }

    }

    public MaterialResponseDto createMaterial(MaterialRequestDto materialRequestDto) {
        Material materialEntity = new Material();
        materialEntity.setName(materialRequestDto.getName());
        materialEntity.setDescription(materialRequestDto.getDescription());
        materialEntity.setPrice(materialRequestDto.getPrice());
        materialEntity.setMaterialType(materialRequestDto.getMaterialType());
        Material result = materialRepository.save(materialEntity);
        return MaterialResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .price(result.getPrice())
                .materialType(materialEntity.getMaterialType())
                .build();
    }

    public MaterialResponseDto changePriceMaterial(Long id, MaterialRequestDto materialRequestDto) {
        Optional<Material> materialEntityOptional = materialRepository.findById(id);
        Material materialEntity = materialEntityOptional.get();
        materialEntity.setPrice(materialRequestDto.getPrice());
        Material result = materialRepository.save(materialEntity);
        return MaterialResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .price(result.getPrice())
                .materialType(materialEntity.getMaterialType())
                .build();

    }

    public MaterialResponseDto changeDescriptionMaterial(Long id, MaterialRequestDto materialRequestDto) {
        Optional<Material> materialEntityOptional = materialRepository.findById(id);
        Material materialEntity = materialEntityOptional.get();
        materialEntity.setDescription(materialRequestDto.getDescription());
        Material result = materialRepository.save(materialEntity);
        return MaterialResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .price(result.getPrice())
                .materialType(materialEntity.getMaterialType())
                .build();

    }

    public void deleteMaterial(Long id) {
        Optional<Material> materialEntityOptional = materialRepository.findById(id);
        Material materialEntity = materialEntityOptional.get();
        materialRepository.delete(materialEntity);
    }

}
