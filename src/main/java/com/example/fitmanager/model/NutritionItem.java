package com.example.fitmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public interface NutritionItem {
    String getName();
    double getProteins();
    double getFats();
    double getCarbs();
    double getCalories();
}