package com.sniklz.pizzaservice.dto.mapper;

public interface RequestDtoMapper<D, M> {
    M toModel(D requestDto);
}
