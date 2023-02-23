package com.sniklz.pizzaservice.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PizzaResponseDto {
    private Long id;
    private String name;
    private String description;
    private List<Long> ingredients;
    private BigDecimal resultCost;
}
