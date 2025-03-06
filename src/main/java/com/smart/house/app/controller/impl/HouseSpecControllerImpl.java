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
    public ResponseEntity<?> createHouseSpec(HouseSpecRequestDto houseSpecRequestDto) {
        try {
            HouseSpecResponseDto response = houseSpecService.createHouseSpec(houseSpecRequestDto);
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
    public ResponseEntity<?> changeHouseSpec(HouseSpecRequestDto houseSpecRequestDto, Long id) throws CustomEntityNotFoundException {
        try {
            HouseSpecResponseDto response = houseSpecService.changeHouseSpec(houseSpecRequestDto, id);
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
    public void deleteHouseSpec(Long id) throws CustomEntityNotFoundException {
        houseSpecService.deleteHouseSpec(id);
    }
}
