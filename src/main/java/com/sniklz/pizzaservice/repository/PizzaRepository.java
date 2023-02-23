package com.sniklz.pizzaservice.repository;

import com.sniklz.pizzaservice.model.Ingredient;
import com.sniklz.pizzaservice.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    //List<Pizza> findAllByIngredientsIn(Collection<List<Ingredient>> ingredients);
    //List<Pizza> findPizzasByIngredientsIn(Collection<Set<Ingredient>> ingredients)
    //List<Pizza> findPizzasByIngredientsIn(Collection<List<Ingredient>> ingredients)
}
