package com.smart.house.app.mapper;

import com.smart.house.app.dto.device.SmartDeviceResponseDto;
import com.smart.house.app.dto.material.MaterialResponseDto;
import com.smart.house.app.entity.Material;
import com.smart.house.app.entity.SmartDevice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);


    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    MaterialResponseDto toDto(Material entity);
}