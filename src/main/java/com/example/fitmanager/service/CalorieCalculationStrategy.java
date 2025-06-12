package com.example.fitmanager.service;

public interface CalorieCalculationStrategy {
    double calculate(double weight, double height, int age, String gender, double activityLevel);
}