package com.sniklz.pizzaservice.service.mapper.Impl;

import com.sniklz.pizzaservice.dto.request.IngredientRequestDto;
import com.sniklz.pizzaservice.dto.response.IngredientResponseDto;
import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.service.mapper.UniversalDtoMapper;
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
        return ingredient;
    }

    @Override
    public IngredientResponseDto toDto(Ingredient model) {
        IngredientResponseDto responseDto = new IngredientResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        return responseDto;
    }
}
