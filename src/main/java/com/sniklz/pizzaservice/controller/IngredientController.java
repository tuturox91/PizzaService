package com.sniklz.pizzaservice.controller;

import com.sniklz.pizzaservice.dto.request.IngredientRequestDto;
import com.sniklz.pizzaservice.dto.response.IngredientResponseDto;
import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.service.IngredientService;
import com.sniklz.pizzaservice.service.impl.IngredientServiceImpl;
import com.sniklz.pizzaservice.dto.mapper.UniversalDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {


    private final UniversalDtoMapper<IngredientRequestDto, IngredientResponseDto, Ingredient> mapper;

    private final IngredientService ingredientService;

    public IngredientController(UniversalDtoMapper<IngredientRequestDto, IngredientResponseDto, Ingredient> mapper, IngredientServiceImpl ingredientService) {
        this.mapper = mapper;
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public IngredientResponseDto addIngredient(@RequestBody IngredientRequestDto requestDto) {
        return mapper.toDto(ingredientService.save(mapper.toModel(requestDto)));
    }


    @GetMapping("{id}")
    public IngredientResponseDto getIngredientById(@PathVariable Long id) {
        return mapper.toDto(ingredientService.get(id));
    }

    @PutMapping("{id}")
    public IngredientResponseDto updateIngredient(@PathVariable Long id, @RequestBody IngredientRequestDto requestDto) {
        return mapper.toDto(ingredientService.update(id, mapper.toModel(requestDto)));
    }

    @PutMapping("id")
    public IngredientResponseDto updateCost(@PathVariable Long id, @RequestParam BigDecimal cost) {
        return mapper.toDto(ingredientService.updateCost(id,cost));
    }
}
