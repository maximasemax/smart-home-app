package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.SmartDeviceTypeController;
import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeRequestDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.service.SmartDeviceTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smart-device-type")
public class SmartDeviceTypeControllerImpl implements SmartDeviceTypeController {

    private final SmartDeviceTypeService smartDeviceTypeService;

    @GetMapping(value = "id")
    @Override
    public ResponseEntity<?> getSmartDeviceType(Long id) {
        try {
            SmartDeviceTypeResponseDto response = smartDeviceTypeService.getSmartDeviceType(id);
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
    public ResponseEntity<?> createSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto) {
        try {
            SmartDeviceTypeResponseDto response = smartDeviceTypeService.
                    createSmartDeviceType(smartDeviceTypeRequestDto);
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
    public ResponseEntity<?> changeSmartDeviceType(SmartDeviceTypeRequestDto smartDeviceTypeRequestDto, Long id) {
        try {
            SmartDeviceTypeResponseDto response = smartDeviceTypeService.
                    changeSmartDeviceType(smartDeviceTypeRequestDto, id);
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
    public void deleteSmartDeviceType(Long id) {
        smartDeviceTypeService.deleteSmartDeviceType(id);
    }
}
