package com.sniklz.pizzaservice.service.impl;

import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.repository.IngredientRepository;
import com.sniklz.pizzaservice.service.IngredientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;

    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient save(Ingredient model) {
        return repository.save(model);
    }


    @Override
    public Ingredient get(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Ingredient update(Long id, Ingredient model) {
        Ingredient ingredient = repository.getReferenceById(id);
        ingredient.setName(model.getName());
        ingredient.setCost(model.getCost());
        save(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient updateCost(Long id, BigDecimal cost) {
        Ingredient ingredient = get(id);
        ingredient.setCost(cost);
        save(ingredient);
        return ingredient;
    }
}
