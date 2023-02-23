package com.sniklz.pizzaservice.dto.mapper;

public interface ResponseDtoMapper<D, M> {
    D toDto(M model);
}
