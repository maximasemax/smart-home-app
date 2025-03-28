package com.smart.house.app.dto.HouseSpec.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class HouseSpecRequestDto {

    private Byte floors;

    private BigDecimal totalCost;
}
