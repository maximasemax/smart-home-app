package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.UserController;
import com.smart.house.app.dto.material.MaterialRequestDto;
import com.smart.house.app.dto.user.UserRequestDto;
import com.smart.house.app.dto.user.UserResponseDto;
import com.smart.house.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @GetMapping(value = "name")
    @Override
    public UserResponseDto getUser(String name) {
        return userService.getUser(name); // пока закомментить
    }

    @GetMapping(value = "id")
    @Override
    public UserResponseDto getUser(Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) { // обернуть в ResponseEntity
        return userService.createUser(userRequestDto);
    }

    // свой Dto под каждый request и response
    @PutMapping
    @Override
    public UserResponseDto changeUser(UserRequestDto userRequestDto, Long id) { // лучше назвать editUser
        return userService.changeUser(userRequestDto,id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
