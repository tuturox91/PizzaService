package com.sniklz.pizzaservice.service.impl;

import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.repository.IngredientRepository;
import com.sniklz.pizzaservice.service.DefaultService;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements DefaultService<Ingredient> {

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
        save(ingredient);
        return ingredient;
    }
}
