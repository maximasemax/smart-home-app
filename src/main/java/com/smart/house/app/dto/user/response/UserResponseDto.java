package com.smart.house.app.dto.user.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponseDto {
    private String phoneNumber;

        private String fio;

}
