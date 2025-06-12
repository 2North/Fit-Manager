package com.example.fitmanager.service;

public class CalorieCalculator {
    private CalorieCalculationStrategy strategy;

    public void setStrategy(CalorieCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeCalculation(double weight, double height, int age, String gender, double activityLevel) {
        if (strategy == null) {
            throw new IllegalStateException("Стратегия не выбрана!");
        }
        return strategy.calculate(weight, height, age, gender, activityLevel);
    }
}