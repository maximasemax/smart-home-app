package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.UserController;
import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.dto.user.UserRequestDto;
import com.smart.house.app.dto.user.UserResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    /*@GetMapping(value = "name")
    @Override
    public ResponseEntity<?> getUser(String name) {
         // пока закомментить
        try {
            UserResponseDto response = userService.getUser(name);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
*/
    @GetMapping(value = "id")
    @Override
    public ResponseEntity<?> getUser(Long id) {
        try {
            UserResponseDto response = userService.getUser(id);
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
    public ResponseEntity<?> createUser(UserRequestDto userRequestDto) { // обернуть в ResponseEntity
        try {
            UserResponseDto response = userService.createUser(userRequestDto);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // свой Dto под каждый request и response
    @PutMapping
    @Override
    public ResponseEntity<?> changeUser(UserRequestDto userRequestDto, Long id) { // лучше назвать editUser
        try {
            UserResponseDto response = userService.changeUser(userRequestDto,id);
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
    public void deleteUser(Long id) throws CustomEntityNotFoundException {
        userService.deleteUser(id);
    }
}
