package com.smart.house.app.service;


import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.entity.Material;
import com.smart.house.app.repository.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialResponseDto getMaterial(String name){
        Material materialEntity = materialRepository.findByName(name).orElseThrow(() ->
                new EntityNotFoundException("Material not found"));
        return MaterialResponseDto.builder()
                .price(materialEntity.getPrice())
                .name(materialEntity.getName())
                .description(materialEntity.getDescription())
                .build();

    }

    public MaterialResponseDto createMaterial(MaterialRequestDto materialRequestDto){
        Material materialEntity = new Material();
        materialEntity.setName(materialRequestDto.getName());
        materialEntity.setDescription(materialRequestDto.getDescription());
        materialEntity.setPrice(materialRequestDto.getPrice());
        Material result = materialRepository.save(materialEntity);
        return MaterialResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .price(result.getPrice())
                .build();
    }

    public MaterialResponseDto changePriceMaterial(Long id, MaterialRequestDto materialRequestDto) {
        Material materialEntity = materialRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Material not found"));
        materialEntity.setPrice(materialRequestDto.getPrice());
        Material result = materialRepository.save(materialEntity);
        return MaterialResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .price(result.getPrice())
                .build();

    }

    public MaterialResponseDto changeDescriptionMaterial(Long id, MaterialRequestDto materialRequestDto) {
        Material materialEntity = materialRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Material not found"));
        materialEntity.setDescription(materialRequestDto.getDescription());
        Material result = materialRepository.save(materialEntity);
        return MaterialResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .price(result.getPrice())
                .build();

    }

    public void deleteMaterial(Long id) {
        Material materialEntity = materialRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Material not found"));
        materialRepository.delete(materialEntity);
    }

}
