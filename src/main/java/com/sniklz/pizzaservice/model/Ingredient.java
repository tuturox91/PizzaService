package com.sniklz.pizzaservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "ingredients")
@Data
public class Ingredient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "ingredient_name")
    private String name;
    private BigDecimal cost;
}
