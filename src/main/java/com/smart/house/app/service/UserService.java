package com.smart.house.app.service;

import com.smart.house.app.dto.device.SmartDeviceRequestDto;
import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.dto.user.UserRequestDto;
import com.smart.house.app.dto.user.UserResponseDto;
import com.smart.house.app.entity.SmartDevice;
import com.smart.house.app.entity.User;
import com.smart.house.app.exception.CustomEntityNotFoundException;
import com.smart.house.app.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository; // узнать зачем тут final и что будет если его убрать

    public UserResponseDto getUser(Long id) throws CustomEntityNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userEntity = userOptional.get();
            return UserResponseDto.builder()
                    .name(userEntity.getName())
                    .phoneNumber(userEntity.getPhoneNumber())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("User not found");
        }
    }

/*    public UserResponseDto getUser(String name){
        User userEntity = userRepository.findByName(name).orElseThrow(() ->
                new EntityNotFoundException("User not found")); // не кидать тут Runtime
        return UserResponseDto.builder()
                .name(userEntity.getName())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }*/

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User userEntity = new User();
        userEntity.setName(userRequestDto.getName());
        userEntity.setPhoneNumber(userRequestDto.getPhoneNumber());
        User result = userRepository.save(userEntity);
        return UserResponseDto.builder()
                .phoneNumber(result.getPhoneNumber())
                .name(result.getName())
                .build();
    }

    public UserResponseDto changeUser(UserRequestDto userRequestDto, Long id) throws CustomEntityNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userEntity = userOptional.get();
            userEntity.setName(userRequestDto.getName());
            userEntity.setPhoneNumber(userRequestDto.getPhoneNumber());
            User result = userRepository.save(userEntity);
            return UserResponseDto.builder()
                    .phoneNumber(result.getPhoneNumber())
                    .name(result.getName())
                    .build();
        } else {
            throw new CustomEntityNotFoundException("User not found");
        }
    }

    public void deleteUser(Long id) throws CustomEntityNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userEntity = userOptional.get();
            userRepository.delete(userEntity);
        } else {
            throw new CustomEntityNotFoundException("User not found");
        }
    }
}
