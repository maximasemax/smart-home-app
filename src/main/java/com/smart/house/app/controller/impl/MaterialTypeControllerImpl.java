package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.MaterialTypeController;
import com.smart.house.app.dto.material_type.request.MaterialTypeRequestDto;
import com.smart.house.app.dto.material_type.response.MaterialTypeResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.service.MaterialTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material-type")
@Log4j2
public class MaterialTypeControllerImpl implements MaterialTypeController {

    private final MaterialTypeService materialTypeService;

    @GetMapping(value = "id")
    @Override
    public ResponseEntity<?> getMaterialType(Long id) {
        log.info("Получен запрос на получение типа материала с ID: {}", id);
        try {
            log.info("Поиск типа материала с ID: {}", id);
            MaterialTypeResponseDto response = materialTypeService.getMaterialType(id);
            log.info("Отправка ответа по типу материала с ID: {}", id);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            log.info("Не найден тип материала с ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Material type not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            log.info("Некорректный ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при получении типа материала с ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createMaterialType(MaterialTypeRequestDto materialTypeRequestDto) {
        log.info("Получен запрос на создание типа материала");
        try {
            log.info("Создание типа материала");
            MaterialTypeResponseDto response = materialTypeService.createMaterialType(materialTypeRequestDto);
            log.info("Отправка ответа по типу материала");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            log.info("Некорректные данные: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при создании типа материала: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<?> editMaterialType(MaterialTypeRequestDto materialTypeRequestDto, Long id) {
        log.info("Получен запрос на изменение типа материала с ID: {}", id);
        try {
            log.info("Изменение типа материала с ID: {}", id);
            MaterialTypeResponseDto response = materialTypeService.changeMaterialType(materialTypeRequestDto, id);
            log.info("Отправка ответа по типу материала с ID: {}", id);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            log.info("Не найден тип материала с ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Material type not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            log.info("Некорректные данные ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при изменении типа материала с ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAllMaterialTypes() {
        log.info("Получен запрос на получение всех типов материалов");
        try {
            List<MaterialTypeResponseDto> responseList = materialTypeService.getAllMaterialTypes();
            return ResponseEntity.ok(responseList);
        } catch (Exception e) {
            log.error("Ошибка при получении : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteMaterialType(Long id) throws CustomEntityNotFoundException {
        materialTypeService.deleteMaterialType(id);
    }
}
