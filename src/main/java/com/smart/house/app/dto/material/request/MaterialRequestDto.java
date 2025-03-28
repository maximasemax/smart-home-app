package com.smart.house.app.dto.material.request;

import com.smart.house.app.entity.MaterialType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class MaterialRequestDto {

    private String name;

    private String description;

    private BigDecimal price;

    private MaterialType materialType;
}
