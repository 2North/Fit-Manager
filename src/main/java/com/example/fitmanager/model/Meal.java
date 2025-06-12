package com.example.fitmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "meals")
public class Meal implements NutritionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "meal_food",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> ingredients = new ArrayList<>();

    @Override
    public double getCalories() {
        return ingredients.stream().mapToDouble(Food::getCalories).sum();
    }

    @Override
    public double getProteins() {
        return ingredients.stream().mapToDouble(Food::getProteins).sum();
    }

    @Override
    public double getCarbs() {
        return ingredients.stream().mapToDouble(Food::getCarbs).sum();
    }

    @Override
    public double getFats() {
        return ingredients.stream().mapToDouble(Food::getFats).sum();
    }

}
