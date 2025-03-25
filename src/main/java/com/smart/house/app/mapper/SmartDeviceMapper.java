package com.smart.house.app.mapper;

import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.entity.SmartDevice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SmartDeviceMapper {

    SmartDeviceMapper INSTANCE = Mappers.getMapper(SmartDeviceMapper.class);

    @Mapping(target = "name", source = "name")
    SmartDeviceResponseDto toDto(SmartDevice entity);

}
