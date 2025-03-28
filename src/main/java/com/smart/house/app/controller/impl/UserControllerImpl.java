package com.smart.house.app.controller.impl;

import com.smart.house.app.controller.UserController;
import com.smart.house.app.dto.user.request.UserRequestDto;
import com.smart.house.app.dto.user.response.UserResponseDto;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Log4j2
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
    public ResponseEntity<?> getUser(@RequestParam Long id) {
        log.info("Получен запрос на получение пользователя с ID: {}", id);
        try {
            log.info("Поиск пользователя с ID: {}", id);
            UserResponseDto response = userService.getUser(id);
            log.info("Отправка ответа по пользователю с ID: {}", id);
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            log.info("Не найден пользователь с ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(NOT_FOUND)
                    .body(Map.of("error", "User not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            log.info("Не правильный тип данных ID : {} :{}", id, e.getMessage());
            return ResponseEntity.status(BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при получении пользователя с ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal server error", "message", e.getMessage()));
        }
    }


    @PostMapping
    @Override
    public ResponseEntity<?> createUser(UserRequestDto userRequestDto) {
        log.info("Получен запрос на создание пользователя ");
        try {
            log.info("Создание пользователя");
            UserResponseDto response = userService.createUser(userRequestDto);
            log.info("Отправка ответа по пользователю");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            log.info("Не правильный тип данных ID :{}", e.getMessage());
            return ResponseEntity.status(BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при получении пользователя с ID : {}", e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    // свой Dto под каждый request и response
    @PutMapping
    @Override
    public ResponseEntity<?> editUser(UserRequestDto userRequestDto, Long id) { // лучше назвать editUser
        log.info("Получен запрос на изменение пользователя ");
        try {
            log.info("Изменение пользовател");
            UserResponseDto response = userService.changeUser(userRequestDto,id);
            log.info("Отправка ответа по изменению пользователю");
            return ResponseEntity.ok(response);
        } catch (CustomEntityNotFoundException e) {
            log.info("Не найден пользователь с ID: {}: {}", id, e.getMessage());
            return ResponseEntity.status(NOT_FOUND)
                    .body(Map.of("error", "User not found", "message", e.getMessage()));
        } catch (IllegalArgumentException e) {
            log.info("Не правильный тип данных ID : {} :{}", id, e.getMessage());
            return ResponseEntity.status(BAD_REQUEST)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        } catch (Exception e) {
            log.error("Ошибка при получении пользователя с ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Invalid request", "message", e.getMessage()));
        }

    }

    @DeleteMapping(value = "id")
    @Override
    public void deleteUser(Long id) throws CustomEntityNotFoundException {
        userService.deleteUser(id);
    }
}
