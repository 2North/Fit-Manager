package com.example.fitmanager.service.observer;

public class NutritionAlert implements Observer {
    private String name;

    public NutritionAlert(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Уведомление [" + name + "]: " + message);
    }
}