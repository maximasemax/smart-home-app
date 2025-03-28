package com.smart.house.app.dto.device.response;


import com.smart.house.app.entity.SmartDeviceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SmartDeviceResponseDto {

    private String name;

    private SmartDeviceType smartDeviceType;
}
