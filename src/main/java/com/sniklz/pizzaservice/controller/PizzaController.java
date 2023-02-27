package com.sniklz.pizzaservice.controller;

import com.sniklz.pizzaservice.dto.request.PizzaRequestDto;
import com.sniklz.pizzaservice.dto.response.PizzaResponseDto;
import com.sniklz.pizzaservice.model.Pizza;
import com.sniklz.pizzaservice.dto.mapper.UniversalDtoMapper;
import com.sniklz.pizzaservice.service.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final UniversalDtoMapper<PizzaRequestDto, PizzaResponseDto, Pizza> mapper;
    private final PizzaService pizzaservice;

    public PizzaController(
            UniversalDtoMapper<PizzaRequestDto,
            PizzaResponseDto, Pizza> mapper,
            PizzaService pizzaservice) {
        this.mapper = mapper;
        this.pizzaservice = pizzaservice;
    }

    @PostMapping
    public PizzaResponseDto addPizza(@RequestBody PizzaRequestDto requestDto) {
        return mapper.toDto(pizzaservice.saveWithCost(mapper.toModel(requestDto)));
    }

    @GetMapping("{id}")
    public PizzaResponseDto getPizza(@PathVariable Long id) {
        return mapper.toDto(pizzaservice.get(id));
    }

    @PutMapping("{id}")
    public PizzaResponseDto updatePizza(@PathVariable Long id, @RequestBody PizzaRequestDto requestDto) {
        return mapper.toDto(pizzaservice.update(id,mapper.toModel(requestDto)));
    }

    @PostMapping("{id}/cost")
    public PizzaResponseDto calculatePizzaCost(@PathVariable Long id) {
        return mapper.toDto(pizzaservice.calculatePizzaCost(id));
    }

    @GetMapping
    public List<PizzaResponseDto> findAll (@RequestParam Map<String, String> params) {
        return pizzaservice.findAll(params).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
