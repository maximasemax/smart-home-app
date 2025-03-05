package com.smart.house.app.dto.device;


import com.smart.house.app.entity.SmartDeviceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SmartDeviceRequestDto {
    private String name;

    private SmartDeviceType smartDeviceType;

}
