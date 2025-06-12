package com.example.fitmanager.service;

public class HarrisBenedictStrategy implements CalorieCalculationStrategy {
    @Override
    public double calculate(double weight, double height, int age, String gender, double activityLevel) {
        double bmr = gender.equalsIgnoreCase("male")
                ? 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
                : 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        return bmr * activityLevel;
    }
}