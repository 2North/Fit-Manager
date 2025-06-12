package com.example.fitmanager.service.decorator;

import com.example.fitmanager.model.NutritionItem;

public abstract class NutritionItemDecorator implements NutritionItem {
    protected NutritionItem decoratedItem;

    public NutritionItemDecorator(NutritionItem item) {
        this.decoratedItem = item;
    }

    @Override
    public String getName() {
        return decoratedItem.getName();
    }

    @Override
    public double getProteins() {
        return decoratedItem.getProteins();
    }

    @Override
    public double getFats() {
        return decoratedItem.getFats();
    }

    @Override
    public double getCarbs() {
        return decoratedItem.getCarbs();
    }

    @Override
    public double getCalories() {
        return decoratedItem.getCalories();
    }



}