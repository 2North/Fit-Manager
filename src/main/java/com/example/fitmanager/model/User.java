package com.example.fitmanager.model;

import com.example.fitmanager.service.observer.Observer;
import com.example.fitmanager.service.observer.Subject;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User implements Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double weight;
    private double targetProteins;
    private double targetFats;
    private double targetCarbs;
    private double targetCalories;

    @Transient
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Превышена норма макронутриентов для пользователя " + name);
        }
    }

    public void checkNutrition(double proteins, double fats, double carbs, double calories) {
        if (proteins > targetProteins || fats > targetFats || carbs > targetCarbs || calories > targetCalories) {
            notifyObservers();
        }
    }
}