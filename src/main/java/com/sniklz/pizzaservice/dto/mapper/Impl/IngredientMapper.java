package com.sniklz.pizzaservice.dto.mapper.Impl;

import com.sniklz.pizzaservice.dto.mapper.UniversalDtoMapper;
import com.sniklz.pizzaservice.dto.request.IngredientRequestDto;
import com.sniklz.pizzaservice.dto.response.IngredientResponseDto;
import com.sniklz.pizzaservice.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper implements
        UniversalDtoMapper<IngredientRequestDto,
                IngredientResponseDto,
                Ingredient> {

    @Override
    public Ingredient toModel(IngredientRequestDto requestDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(requestDto.getName());
        ingredient.setCost(requestDto.getCost());
        return ingredient;
    }

    @Override
    public IngredientResponseDto toDto(Ingredient model) {
        IngredientResponseDto responseDto = new IngredientResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setCost(model.getCost());
        return responseDto;
    }
}
