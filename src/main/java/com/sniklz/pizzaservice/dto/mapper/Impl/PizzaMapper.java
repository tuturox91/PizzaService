package com.sniklz.pizzaservice.dto.mapper.Impl;

import com.sniklz.pizzaservice.dto.mapper.UniversalDtoMapper;
import com.sniklz.pizzaservice.dto.request.PizzaRequestDto;
import com.sniklz.pizzaservice.dto.response.PizzaResponseDto;
import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.model.Pizza;
import com.sniklz.pizzaservice.service.impl.IngredientServiceImpl;
import com.sniklz.pizzaservice.service.impl.PizzaServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzaMapper implements UniversalDtoMapper<PizzaRequestDto, PizzaResponseDto, Pizza> {

    private final PizzaServiceImpl pizzaService;
    private final IngredientServiceImpl ingredientService;

    public PizzaMapper(PizzaServiceImpl pizzaService, IngredientServiceImpl ingredientService) {
        this.pizzaService = pizzaService;
        this.ingredientService = ingredientService;
    }

    @Override
    public Pizza toModel(PizzaRequestDto requestDto) {
        Pizza pizza = new Pizza();
        pizza.setName(requestDto.getName());
        pizza.setDescription(requestDto.getDescription());
        pizza.setResultCost(requestDto.getResultCost());
        List<Ingredient> ingredients = requestDto.getIngredients()
                .stream().map(ingredientService::get).toList();

        pizza.setIngredients(ingredients);
        return pizza;
    }

    @Override
    public PizzaResponseDto toDto(Pizza model) {
        PizzaResponseDto responseDto = new PizzaResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setDescription(model.getDescription());
        responseDto.setResultCost(model.getResultCost());
        responseDto.setIngredients(model.getIngredients()
                .stream()
                .map(Ingredient::getId)
                .toList());
        return responseDto;
    }
}
