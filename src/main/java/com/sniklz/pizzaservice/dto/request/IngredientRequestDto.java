package com.sniklz.pizzaservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientRequestDto {
    private String name;
    @NotNull
    private BigDecimal cost;
}
