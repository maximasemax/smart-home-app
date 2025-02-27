package com.smart.house.app.controller;

import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.user.UserRequestDto;
import com.smart.house.app.dto.user.UserResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {
    UserResponseDto getUser(String name);

    UserResponseDto getUser(Long id);

    UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto);

    UserResponseDto changeUser(@RequestBody UserRequestDto userRequestDto, Long id);

    void deleteUser(Long id);
}
