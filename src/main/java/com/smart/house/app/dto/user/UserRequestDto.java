package com.smart.house.app.dto.user;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRequestDto     {
    private String phoneNumber; // попробуй написать валидацию формата через regexp и AOP

    private String fio; // fio
}
