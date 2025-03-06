package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.MaterialTypeController;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.dto.material_type.MaterialTypeRequestDto;
import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import com.smart.house.app.service.MaterialTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material-type")
public class MaterialTypeControllerImpl implements MaterialTypeController {

    private final MaterialTypeService materialTypeService;

    @GetMapping(value = "id")
    @Override
    public ResponseEntity<?> getMaterialType(Long id) {
        try {
            MaterialTypeResponseDto response = materialTypeService.getMaterialType(id);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createMaterialType(MaterialTypeRequestDto materialTypeRequestDto) {
        try {
            MaterialTypeResponseDto response = materialTypeService.createMaterialType(materialTypeRequestDto);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<?> changeMaterialType(MaterialTypeRequestDto materialTypeRequestDto, Long id) {
        try {
            MaterialTypeResponseDto response = materialTypeService.changeMaterialType(materialTypeRequestDto, id);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteMaterialType(Long id) {
        materialTypeService.deleteMaterialType(id);
    }
}
