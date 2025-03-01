package com.smart.house.app.dto.HouseSpec;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class HouseSpecRequestDto {
    private Integer floors; // юзать тип покороче

    private BigDecimal totalCost;
}
