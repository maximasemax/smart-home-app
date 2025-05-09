package com.smart.house.app.service;


import com.smart.house.app.dto.material.request.MaterialRequestDto;
import com.smart.house.app.dto.material.response.MaterialResponseDto;
import com.smart.house.app.entity.Material;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.mapper.MaterialMapper;
import com.smart.house.app.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

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
        } else {
            throw new CustomEntityNotFoundException("Material not found");
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

    public MaterialResponseDto changePriceMaterial(Long id, MaterialRequestDto materialRequestDto) throws CustomEntityNotFoundException {
        Optional<Material> materialEntityOptional = materialRepository.findById(id);
        if (materialEntityOptional.isPresent()) {
            Material materialEntity = materialEntityOptional.get();
            materialEntity.setPrice(materialRequestDto.getPrice());
            Material result = materialRepository.save(materialEntity);
            return MaterialResponseDto.builder()
                    .price(materialEntity.getPrice())
                    .name(materialEntity.getName())
                    .description(materialEntity.getDescription())
                    .materialType(materialEntity.getMaterialType())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("Material not found");
        }

    }

    public MaterialResponseDto changeDescriptionMaterial(Long id, MaterialRequestDto materialRequestDto) throws CustomEntityNotFoundException {
        Optional<Material> materialEntityOptional = materialRepository.findById(id);
        if (materialEntityOptional.isPresent()) {
            Material materialEntity = materialEntityOptional.get();
            materialEntity.setDescription(materialRequestDto.getDescription());
            Material result = materialRepository.save(materialEntity);
            return MaterialResponseDto.builder()
                    .name(result.getName())
                    .description(result.getDescription())
                    .price(result.getPrice())
                    .materialType(materialEntity.getMaterialType())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("Material not found");
        }
    }

    public void deleteMaterial(Long id) throws CustomEntityNotFoundException {
        Optional<Material> materialEntityOptional = materialRepository.findById(id);
        if (materialEntityOptional.isPresent()) {
            Material materialEntity = materialEntityOptional.get();
            materialRepository.delete(materialEntity);
        } else {
            throw new CustomEntityNotFoundException("Material not found");
        }
    }

    public List<MaterialResponseDto> getAllMaterials() {
        log.info("Попытка сходить в базу");
        List<Material> materialList = materialRepository.findAll();
        log.info("Попытка маппинга");
        return materialList.stream()
                .map(materialMapper::toDto)
                .collect(Collectors.toList());
    }
}
