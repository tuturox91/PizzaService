package com.sniklz.pizzaservice.dto.mapper;

public interface UniversalDtoMapper<R, T, M>
        extends RequestDtoMapper<R, M>, ResponseDtoMapper<T, M> {
}
