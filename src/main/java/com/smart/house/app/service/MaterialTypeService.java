package com.smart.house.app.service;

import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.dto.material_type.MaterialTypeRequestDto;
import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import com.smart.house.app.entity.Material;
import com.smart.house.app.entity.MaterialType;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.mapper.MaterialTypeMapper;
import com.smart.house.app.repository.MaterialTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class MaterialTypeService {

    private final MaterialTypeRepository materialTypeRepository;
    private final MaterialTypeMapper materialTypeMapper;

    public MaterialTypeResponseDto getMaterialType(Long id) throws CustomEntityNotFoundException {

        Optional<MaterialType> materialTypeTypeEntityOptional = materialTypeRepository.findById(id);
        if (materialTypeTypeEntityOptional.isPresent()) {
            MaterialType materialTypeTypeEntity = materialTypeTypeEntityOptional.get();
            return MaterialTypeResponseDto.builder()
                    .type(materialTypeTypeEntity.getType())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("MaterialType not found");
        }
    }


    public MaterialTypeResponseDto createMaterialType(MaterialTypeRequestDto materialTypeRequestDto) {
        MaterialType materialTypeEntity = new MaterialType();
        materialTypeEntity.setType(materialTypeRequestDto.getType());
        MaterialType result = materialTypeRepository.save(materialTypeEntity);
        return MaterialTypeResponseDto.builder()
                .type(result.getType())
                .build();
    }

    public MaterialTypeResponseDto changeMaterialType(MaterialTypeRequestDto materialTypeRequestDto, Long id) throws CustomEntityNotFoundException {
        Optional<MaterialType> materialTypeTypeEntityOptional = materialTypeRepository.findById(id);
        if (materialTypeTypeEntityOptional.isPresent()) {
            MaterialType materialTypeEntity = new MaterialType();
            materialTypeEntity.setType(materialTypeRequestDto.getType());
            MaterialType result = materialTypeRepository.save(materialTypeEntity);
            return MaterialTypeResponseDto.builder()
                    .type(result.getType())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("MaterialType not found");
        }
    }

    public List<MaterialTypeResponseDto> getAllMaterialTypes() {
        log.info("Попытка сходить в базу");
        List<MaterialType> materialList = materialTypeRepository.findAll();
        log.info("Попытка маппинга");
        return materialList.stream()
                .map(materialTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteMaterialType(Long id) throws CustomEntityNotFoundException {
        Optional<MaterialType> materialTypeOptional = materialTypeRepository.findById(id);
        if (materialTypeOptional.isPresent()) {
            MaterialType materialTypeEntity = materialTypeOptional.get();
            materialTypeRepository.delete(materialTypeEntity);
        } else {
            throw new CustomEntityNotFoundException("MaterialType not found");
        }
    }
}
