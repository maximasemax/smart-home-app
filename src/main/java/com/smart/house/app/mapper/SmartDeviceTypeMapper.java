package com.smart.house.app.mapper;


import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.entity.SmartDeviceType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SmartDeviceTypeMapper {

    SmartDeviceTypeMapper INSTANCE = Mappers.getMapper(SmartDeviceTypeMapper.class);

    @Mapping(target = "type", source = "type")
    SmartDeviceTypeResponseDto toDto(SmartDeviceType entity);
}
