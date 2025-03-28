package com.smart.house.app.mapper;

import com.smart.house.app.dto.material_type.response.MaterialTypeResponseDto;
import com.smart.house.app.entity.MaterialType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaterialTypeMapper {

    MaterialTypeMapper INSTANCE = Mappers.getMapper(MaterialTypeMapper.class);

    @Mapping(target = "type", source = "type")
    MaterialTypeResponseDto toDto(MaterialType entity);
}
