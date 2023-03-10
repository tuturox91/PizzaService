package com.sniklz.pizzaservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table (name = "pizzas")
@Data
public class Pizza {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "pizza_name")
    private String name;
    @Column (name = "pizza_description")
    private String description;
    private BigDecimal resultCost;
    @ManyToMany
    @JoinTable(name = "pizzas_ingredients",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients;

    @Enumerated (value = EnumType.STRING)
    private PizzaType pizzaSize;

    public enum PizzaType {
        SMALL("small"),
        LARGE("large");

        private String name;

        PizzaType(String value) {
            name = value;
        }

    }

}
