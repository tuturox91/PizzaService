package com.sniklz.pizzaservice.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientResponseDto {
    private Long id;
    private String name;
    private BigDecimal cost;
}
