package com.sniklz.pizzaservice.service.impl;

import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.model.Pizza;
import com.sniklz.pizzaservice.repository.PizzaRepository;
import com.sniklz.pizzaservice.repository.specification.PizzaSpecificationManager;
import com.sniklz.pizzaservice.service.IngredientService;
import com.sniklz.pizzaservice.service.PizzaService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository repository;
    private final IngredientService ingredientService;

    private final PizzaSpecificationManager specificationManager;

    public PizzaServiceImpl(PizzaRepository repository,
                            IngredientService ingredientService,
                            PizzaSpecificationManager specificationManager) {
        this.repository = repository;
        this.ingredientService = ingredientService;
        this.specificationManager = specificationManager;
    }

    @Override
    public Pizza save(Pizza model) {
        return repository.save(model);
    }

    @Override
    public Pizza saveWithCost(Pizza model) {
        BigDecimal resultCost =  calculateCost(model.getIngredients());
        model.setResultCost(resultCost);
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
        BigDecimal result = calculateCost(pizza.getIngredients());
        pizza.setResultCost(result);
        save(pizza);
        return pizza;
    }

    private BigDecimal calculateCost(Set<Ingredient> ingredientSet) {
        BigDecimal result = ingredientSet
                .stream()
                .map(Ingredient::getCost)
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        return result;
    }


    @Override
    public List<Pizza> findAll(Map<String, String> params) {
        Specification<Pizza> specification = null;
        for(Map.Entry<String, String> entry: params.entrySet()) {
            Specification<Pizza> sp = specificationManager.get(entry.getKey(),
                    entry.getValue().split(","));
            specification = specification == null ? Specification.where(sp) : specification.and(sp);
        }
        return repository.findAll(specification);
    }
}
