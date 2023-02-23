package com.sniklz.pizzaservice.service.mapper;

public interface UniversalDtoMapper<R, T, M>
        extends RequestDtoMapper<R, M>, ResponseDtoMapper<T, M> {
}
