package com.smart.house.app.controller.impl;


import com.smart.house.app.controller.MaterialController;
import com.smart.house.app.dto.material.request.MaterialRequestDto;
import com.smart.house.app.dto.material.response.MaterialResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.exception.CustomMaterialException;
import com.smart.house.app.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material")
@Log4j2
public class MaterialControllerImpl implements MaterialController {

    private final MaterialService materialService;

    @GetMapping(value = "name")
    @Override
    public ResponseEntity<?> getMaterial(@RequestParam  String name) throws CustomMaterialException {
        try {
            MaterialResponseDto response = materialService.getMaterial(name);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Material not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createMaterial(MaterialRequestDto materialRequestDto) { // при отправке запроса содержащим не правильным значение name materialType она не проверяет это поле, но при попытке создания материала с не правильным ключом на тип выдает 500 ошибку
        try {
            MaterialResponseDto response = materialService.createMaterial(materialRequestDto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @PutMapping(value = "change_cost")
    @Override
    public ResponseEntity<?> changeCostMaterial(MaterialRequestDto materialRequestDto, Long id) {
        try {
            MaterialResponseDto response = materialService.changePriceMaterial(id, materialRequestDto);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Material not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @PutMapping(value = "change_description")
    @Override
    public ResponseEntity<?> changeDescriptionMaterial(MaterialRequestDto materialRequestDto, Long id) {
        try {
            MaterialResponseDto response = materialService.changeDescriptionMaterial(id, materialRequestDto);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Material not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAllMaterials() {
        log.info("Получен запрос на получение всех материалов");
        try {
            List<MaterialResponseDto> responseList = materialService.getAllMaterials();
            return ResponseEntity.ok(responseList);
        } catch (Exception e) {
            log.error("Ошибка при получении : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteMaterial(Long id) throws CustomEntityNotFoundException {
        materialService.deleteMaterial(id);
    }

}
