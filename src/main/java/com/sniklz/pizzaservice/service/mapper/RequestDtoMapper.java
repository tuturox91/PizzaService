package com.sniklz.pizzaservice.service.mapper;

public interface RequestDtoMapper<D, M> {
    M toModel(D requestDto);
}
