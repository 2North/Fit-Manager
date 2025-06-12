package com.example.fitmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "foods")
public class Food implements NutritionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double proteins;

    @Column(nullable = false)
    private double carbs;

    @Column(nullable = false)
    private double fats;

    @Column(nullable = false)
    private double calories;

    @Override
    public String getName() { return this.name; }

    @Override
    public double getProteins() { return this.proteins; }

    @Override
    public double getCarbs() { return this.carbs; }

    @Override
    public double getFats() { return this.fats; }

    @Override
    public double getCalories() { return this.calories; }


}