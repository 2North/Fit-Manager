package com.example.fitmanager.service;

import com.example.fitmanager.model.NutritionItem;
import java.util.Iterator;
import java.util.List;

public class NutritionIterator implements Iterator<NutritionItem> {
    private final List<NutritionItem> items;
    private int position = 0;

    public NutritionIterator(List<NutritionItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public NutritionItem next() {
        if (!hasNext()) {
            throw new IllegalStateException("Нет больше элементов!");
        }
        return items.get(position++);
    }
}
