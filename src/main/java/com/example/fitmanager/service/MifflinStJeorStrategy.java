package com.example.fitmanager.service;

public class MifflinStJeorStrategy implements CalorieCalculationStrategy {
    @Override
    public double calculate(double weight, double height, int age, String gender, double activityLevel) {
        double bmr = gender.equalsIgnoreCase("male")
                ? (10 * weight) + (6.25 * height) - (5 * age) + 5
                : (10 * weight) + (6.25 * height) - (5 * age) - 161;
        return bmr * activityLevel;
    }
}