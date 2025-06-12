package com.example.fitmanager.service.decorator;

import com.example.fitmanager.model.NutritionItem;

public class PortionDecorator extends NutritionItemDecorator {
    private double quantity; // Количество в граммах

    public PortionDecorator(NutritionItem item, double quantity) {
        super(item);
        this.quantity = quantity;
    }

    @Override
    public double getProteins() {
        return decoratedItem.getProteins() * quantity / 100;
    }

    @Override
    public double getFats() {
        return decoratedItem.getFats() * quantity / 100;
    }

    @Override
    public double getCarbs() {
        return decoratedItem.getCarbs() * quantity / 100;
    }

    @Override
    public double getCalories() {
        return decoratedItem.getCalories() * quantity / 100;
    }
}