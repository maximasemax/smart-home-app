package com.smart.house.app.controller.impl;


import com.smart.house.app.controller.MaterialController;
import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.exception.CustomMaterialException;
import com.smart.house.app.service.MaterialService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material")
public class MaterialControllerImpl implements MaterialController {

    private final MaterialService materialService;

    @GetMapping(value = "name")
    @Override
    public ResponseEntity<?> getMaterial(@RequestParam  String name) throws CustomMaterialException {
        try {
            MaterialResponseDto response = materialService.getMaterial(name);
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
    public ResponseEntity<?> createMaterial(MaterialRequestDto materialRequestDto) { // при отправке запроса содержащим не правильным значение name materialType она не проверяет это поле, но при попытке создания материала с не правильным ключом на тип выдает 500 ошибку
        try {
            MaterialResponseDto response = materialService.createMaterial(materialRequestDto);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "change_cost")
    @Override
    public ResponseEntity<?> changeCostMaterial(MaterialRequestDto materialRequestDto, Long id) {
        try {
            MaterialResponseDto response = materialService.changePriceMaterial(id, materialRequestDto);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "change_description")
    @Override
    public ResponseEntity<?> changeDescriptionMaterial(MaterialRequestDto materialRequestDto, Long id) {
        try {
            MaterialResponseDto response = materialService.changeDescriptionMaterial(id, materialRequestDto);
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
    public void deleteMaterial(Long id) throws CustomEntityNotFoundException {
        materialService.deleteMaterial(id);
    }

}
