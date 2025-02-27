package com.smart.house.app.dto.material;

import lom
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
}
