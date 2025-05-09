package com.smart.house.app.controller;

import com.smart.house.app.dto.material_type.request.MaterialTypeRequestDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface MaterialTypeController {

    ResponseEntity<?> getMaterialType(Long id);

    ResponseEntity<?> createMaterialType(@RequestBody MaterialTypeRequestDto materialTypeRequestDto);

    ResponseEntity<?> editMaterialType(@RequestBody MaterialTypeRequestDto materialTypeRequestDto, Long id);

    ResponseEntity<?> getAllMaterialTypes();

    void deleteMaterialType(Long id) throws CustomEntityNotFoundException;
}
