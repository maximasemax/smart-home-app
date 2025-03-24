package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.HouseSpecController;
import com.smart.house.app.dto.HouseSpec.HouseSpecRequestDto;
import com.smart.house.app.dto.HouseSpec.HouseSpecResponseDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.service.HouseSpecService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/house-spec")
public class HouseSpecControllerImpl implements HouseSpecController {

    private final HouseSpecService houseSpecService;

    @GetMapping(value = "id")
    @Override
    public ResponseEntity<?> getHouseSpec(Long id) throws CustomEntityNotFoundException {
        try {
            HouseSpecResponseDto response = houseSpecService.getHouseSpec(id);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "House spec not found", "message", e.getMessage()));
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
    public ResponseEntity<?> createHouseSpec(HouseSpecRequestDto houseSpecRequestDto) {
        try {
            HouseSpecResponseDto response = houseSpecService.createHouseSpec(houseSpecRequestDto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }
    @PutMapping
    @Override
    public ResponseEntity<?> editHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id) throws CustomEntityNotFoundException {
        try {
            HouseSpecResponseDto response = houseSpecService.changeHouseSpec(houseSpecRequestDto, id);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "House spec not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }

    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteHouseSpec(Long id) throws CustomEntityNotFoundException {
        houseSpecService.deleteHouseSpec(id);
    }
}
