package com.smart.house.app.service;

import com.smart.house.app.dto.material_type.MaterialTypeRequestDto;
import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import com.smart.house.app.entity.MaterialType;
import com.smart.house.app.repository.MaterialTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialTypeService {

    private final MaterialTypeRepository materialTypeRepository;

    public MaterialTypeResponseDto getMaterialType(Long id){
        MaterialType materialTypeTypeEntity = materialTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("MaterialType not found"));
        return MaterialTypeResponseDto.builder()
                .type(materialTypeTypeEntity.getType())
                .build();
    }


    public MaterialTypeResponseDto createMaterialType(MaterialTypeRequestDto materialTypeRequestDto){
        MaterialType materialTypeEntity = new MaterialType();
        materialTypeEntity.setType(materialTypeRequestDto.getType());
        MaterialType result = materialTypeRepository.save(materialTypeEntity);
        return MaterialTypeResponseDto.builder()
                .type(result.getType())
                .build();
    }

    public MaterialTypeResponseDto changeMaterialType(MaterialTypeRequestDto materialTypeRequestDto, Long id){
        MaterialType materialTypeEntity = materialTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("MaterialType not found"));
        materialTypeEntity.setType(materialTypeRequestDto.getType());
        MaterialType result = materialTypeRepository.save(materialTypeEntity);
        return MaterialTypeResponseDto.builder()
                .type(result.getType())
                .build();
    }

    public void deleteMaterialType(Long id){
        MaterialType materialTypeEntity = materialTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("MaterialType not found"));
        materialTypeRepository.delete(materialTypeEntity);
    }
}
