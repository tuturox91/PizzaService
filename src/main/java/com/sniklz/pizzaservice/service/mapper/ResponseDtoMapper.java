package com.sniklz.pizzaservice.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D toDto(M model);
}
