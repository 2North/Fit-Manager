package com.example.fitmanager.service;
//singleton
public class NutritionCalculator {

    private static NutritionCalculator instance;

    private NutritionCalculator() {}

    public static synchronized NutritionCalculator getInstance() {
        if (instance == null) {
            instance = new NutritionCalculator();
        }
        return instance;
    }


    public double calculateDailyCalories(double weight, double activityCoefficient) {

        return 24 * weight * activityCoefficient;
    }
}