package com.example.fitmanager.service;

import com.example.fitmanager.model.Food;

public class FoodBuilder {
    private String name;
    private double proteins;
    private double fats;
    private double carbs;
    private double calories;

    // Методы для установки полей (возвращают this)
    public FoodBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FoodBuilder setProteins(double proteins) {
        this.proteins = proteins;
        return this;
    }

    public FoodBuilder setFats(double fats) {
        this.fats = fats;
        return this;
    }

    public FoodBuilder setCarbs(double carbs) {
        this.carbs = carbs;
        return this;
    }

    public FoodBuilder setCalories(double calories) {
        this.calories = calories;
        return this;
    }

    // Главный метод build()
    public Food build() {
        validate();
        Food food = new Food();
        food.setName(this.name);
        food.setProteins(this.proteins);
        food.setFats(this.fats);
        food.setCarbs(this.carbs);
        food.setCalories(this.calories);
        return food;
    }

    // Валидация данных
    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название продукта обязательно");
        }
        if (proteins < 0 || fats < 0 || carbs < 0 || calories < 0) {
            throw new IllegalArgumentException("Значения БЖУ и калорий не могут быть отрицательными");
        }
    }
}