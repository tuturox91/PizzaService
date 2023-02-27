package com.sniklz.pizzaservice.service;

import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.model.Pizza;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PizzaService extends DefaultService<Pizza> {
    Pizza calculatePizzaCost(Long id);

    List<Pizza> findAll(Map<String, String> params);
}
