package com.smart.house.app.controller;

import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.user.UserRequestDto;
import com.smart.house.app.dto.user.UserResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {
    /*ResponseEntity<?> getUser(String name);*/

    ResponseEntity<?> getUser(Long id);

    ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequestDto);

    ResponseEntity<?> changeUser(@RequestBody UserRequestDto userRequestDto, Long id);

    void deleteUser(Long id) throws CustomEntityNotFoundException;
}
