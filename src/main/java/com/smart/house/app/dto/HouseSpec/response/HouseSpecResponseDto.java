package com.smart.house.app.dto.HouseSpec.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Builder
@Getter
@Setter
public class HouseSpecResponseDto {

    private Byte floors;

    private BigDecimal totalCost;
}
