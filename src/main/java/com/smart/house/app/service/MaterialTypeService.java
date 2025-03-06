package com.smart.house.app.service;

import com.smart.house.app.dto.material_type.MaterialTypeRequestDto;
import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import com.smart.house.app.entity.MaterialType;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.repository.MaterialTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialTypeService {

    private final MaterialTypeRepository materialTypeRepository;

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
