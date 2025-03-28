package com.smart.house.app.controller;

import com.smart.house.app.dto.user.request.UserRequestDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {
    /*ResponseEntity<?> getUser(String name);*/

    ResponseEntity<?> getUser(Long id);

    ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequestDto);

    ResponseEntity<?> editUser(@RequestBody UserRequestDto userRequestDto, Long id);

    void deleteUser(Long id) throws CustomEntityNotFoundException;
}
