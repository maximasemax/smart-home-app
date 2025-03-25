package com.smart.house.app.mapper;

import com.smart.house.app.dto.material_type.MaterialTypeResponseDto;
import com.smart.house.app.dto.smartDeviceType.SmartDeviceTypeResponseDto;
import com.smart.house.app.entity.MaterialType;
import com.smart.house.app.entity.SmartDeviceType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaterialTypeMapper {

    MaterialTypeMapper INSTANCE = Mappers.getMapper(MaterialTypeMapper.class);

    @Mapping(target = "type", source = "type")
    MaterialTypeResponseDto toDto(MaterialType entity);
}
