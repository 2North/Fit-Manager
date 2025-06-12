package com.example.fitmanager.service;

import com.example.fitmanager.model.NutritionItem;
import java.util.List;

public class NutritionCollection {
    private final List<NutritionItem> items;

    public NutritionCollection(List<NutritionItem> items) {
        this.items = items;
    }

    public NutritionIterator createIterator() {
        return new NutritionIterator(items);
    }
}