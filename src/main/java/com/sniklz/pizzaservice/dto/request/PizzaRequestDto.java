package com.sniklz.pizzaservice.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PizzaRequestDto {
    private String name;
    private String description;
    private List<Long> ingredients;
    private BigDecimal resultCost = BigDecimal.ZERO;
}
