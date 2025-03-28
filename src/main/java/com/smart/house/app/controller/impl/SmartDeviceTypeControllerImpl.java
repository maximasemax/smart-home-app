package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.SmartDeviceTypeController;
import com.smart.house.app.dto.smartDeviceType.request.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.response.SmartDeviceTypeResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.service.SmartDeviceTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smart-device-type")
@Log4j2
public class SmartDeviceTypeControllerImpl implements SmartDeviceTypeController {

    private final SmartDeviceTypeService smartDeviceTypeService;

    @GetMapping(value = "id")
    @Override
    public ResponseEntity<?> getSmartDeviceType(Long id) {
        log.info("Получен запрос на получение типа устройства с ID: {}", id);
        try {
            log.info("Поиск типа устройства с ID: {}", id);
            SmartDeviceTypeResponseDto response = smartDeviceTypeService.getSmartDeviceType(id);
            log.info("Отправка ответа по устройству с ID: {}", id);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            log.info("Не найден тип устройста с ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Smart device type not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            log.info("Не правильный тип данных ID : {} :{}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при получении устройства с ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto) {
        log.info("Получен запрос на создание типа устройства ");
        try {
            log.info("Создание типа устройства");
            SmartDeviceTypeResponseDto response = smartDeviceTypeService.
                    createSmartDeviceType(smartDeviceTypeRequestDto);
            log.info("Отправка ответа по типу устройства");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            log.info("Не правильный тип данных ID :{}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при получении устройства с ID : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<?> editSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto, Long id) {
        log.info("Получен запрос на изменение типа устройства с ID: {}", id);
        try {
            log.info("Изменения типа устройства с ID: {}", id);
            SmartDeviceTypeResponseDto response = smartDeviceTypeService.
                    changeSmartDeviceType(smartDeviceTypeRequestDto, id);
            log.info("Отправка ответа по типу устройствас ID: {}", id);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            log.info("Не найден тип устройста с ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Smart device type not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            log.info("Не правильный тип данных ID : {} :{}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при получении устройства с ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAllSmartDeviceTypes() {
        log.info("Получен запрос на получение всех типов устройств");
        try {
            List<SmartDeviceTypeResponseDto> responseList = smartDeviceTypeService.getAllSmartDeviceTypes();
            return ResponseEntity.ok(responseList);
        } catch (Exception e) {
            log.error("Ошибка при получении : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteSmartDeviceType(Long id) throws CustomEntityNotFoundException {
        smartDeviceTypeService.deleteSmartDeviceType(id);
    }
}
