package com.sniklz.pizzaservice.service.impl;

import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.model.Pizza;
import com.sniklz.pizzaservice.repository.PizzaRepository;
import com.sniklz.pizzaservice.service.IngredientService;
import com.sniklz.pizzaservice.service.PizzaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository repository;
    private final IngredientService ingredientService;

    public PizzaServiceImpl(PizzaRepository repository, IngredientService ingredientService) {
        this.repository = repository;
        this.ingredientService = ingredientService;
    }

    @Override
    public Pizza save(Pizza model) {
        return repository.save(model);
    }

    @Override
    public Pizza get(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Pizza update(Long id, Pizza model) {
        Pizza pizza = get(id);
        pizza.setName(model.getName());
        pizza.setDescription(model.getDescription());
        pizza.setResultCost(model.getResultCost());
        pizza.setIngredients(model.getIngredients());
        save(pizza);
        return pizza;
    }

    @Override
    public Pizza calculatePizzaCost(Long id) {
        Pizza pizza = get(id);
        BigDecimal result = pizza.getIngredients()
                .stream()
                .map(Ingredient::getCost)
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        pizza.setResultCost(result);
        save(pizza);
        return pizza;
    }

    @Override
    public List<Pizza> getAllPizzasByIngredients(List<Long> ingredientsId) {
        List<Ingredient> ingredients = ingredientsId.stream().map(ingredientService::get).toList();
        //return repository.findPizzaByIngredientsContaining(ingredients);
        return null;
    }
}
