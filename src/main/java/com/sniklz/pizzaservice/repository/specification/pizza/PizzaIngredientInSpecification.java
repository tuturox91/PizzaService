package com.sniklz.pizzaservice.repository.specification.pizza;

import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.model.Pizza;
import com.sniklz.pizzaservice.repository.specification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.SetJoin;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PizzaIngredientInSpecification implements SpecificationProvider<Pizza> {
    private static final String FILTER_KEY = "ingredientIn";
    private static final String FIELD_NAME = "name";

    @Override
    public Specification<Pizza> getSpecification(String[] ingredients) {
        return (root, query, criteriaBuilder) -> {
            SetJoin<Pizza, Ingredient> pizzas = root.joinSet("ingredients", JoinType.LEFT);
            CriteriaBuilder.In<String> predicate = criteriaBuilder.in(pizzas.get(FIELD_NAME));
            for(String value: ingredients) {
                predicate.value(value);
            }
            return criteriaBuilder.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
