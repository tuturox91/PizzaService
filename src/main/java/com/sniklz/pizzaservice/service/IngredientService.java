package com.sniklz.pizzaservice.service;

import com.sniklz.pizzaservice.model.Ingredient;

import java.math.BigDecimal;

public interface IngredientService extends DefaultService<Ingredient>  {
   Ingredient updateCost(Long id, BigDecimal cost);
}
