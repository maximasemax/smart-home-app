package com.smart.house.app.controller;

import com.smart.house.app.dto.material.request.MaterialRequestDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.exception.CustomMaterialException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface MaterialController {

    ResponseEntity<?> getMaterial(String name) throws CustomMaterialException;

    ResponseEntity<?> createMaterial(@RequestBody MaterialRequestDto materialRequestDto);

    ResponseEntity<?> changeCostMaterial(@RequestBody MaterialRequestDto materialRequestDto, Long id);

    ResponseEntity<?> changeDescriptionMaterial(@RequestBody MaterialRequestDto materialRequestDto, Long id);

    ResponseEntity<?> getAllMaterials();

    void deleteMaterial(Long id) throws CustomEntityNotFoundException;
}
