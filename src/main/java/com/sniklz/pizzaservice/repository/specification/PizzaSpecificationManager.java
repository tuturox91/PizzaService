package com.sniklz.pizzaservice.repository.specification;

import com.sniklz.pizzaservice.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PizzaSpecificationManager implements SpecificationManager<Pizza> {

    private final Map<String, SpecificationProvider<Pizza>> providerMap;

    @Autowired
    public PizzaSpecificationManager(List<SpecificationProvider<Pizza>> pizzaSpecifications) {
        this.providerMap = pizzaSpecifications.stream()
                .collect(Collectors.toMap(SpecificationProvider::getFilterKey, Function.identity()));
    }

    @Override
    public Specification<Pizza> get(String filterKey, String[] params) {
        if(!providerMap.containsKey(filterKey)) {
            throw new RuntimeException("Key" + filterKey + " is not supported for data filtering");
        }
        return providerMap.get(filterKey).getSpecification(params);
    }
}
