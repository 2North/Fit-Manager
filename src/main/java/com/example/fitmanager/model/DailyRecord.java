package com.example.fitmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "daily_records")
public class DailyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "dailyRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordFood> foods = new ArrayList<>();

    @OneToMany(mappedBy = "dailyRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordMeal> meals = new ArrayList<>();

    public double getTotalProteins() {
        double fromFoods = foods.stream()
                .mapToDouble(rf -> rf.getFood().getProteins() * rf.getQuantity() / 100)
                .sum();
        double fromMeals = meals.stream()
                .mapToDouble(rm -> rm.getMeal().getProteins() * rm.getQuantity() / 100)
                .sum();
        return fromFoods + fromMeals;
    }

    public double getTotalFats() {
        double fromFoods = foods.stream()
                .mapToDouble(rf -> rf.getFood().getFats() * rf.getQuantity() / 100)
                .sum();
        double fromMeals = meals.stream()
                .mapToDouble(rm -> rm.getMeal().getFats() * rm.getQuantity() / 100)
                .sum();
        return fromFoods + fromMeals;
    }

    public double getTotalCarbs() {
        double fromFoods = foods.stream()
                .mapToDouble(rf -> rf.getFood().getCarbs() * rf.getQuantity() / 100)
                .sum();
        double fromMeals = meals.stream()
                .mapToDouble(rm -> rm.getMeal().getCarbs() * rm.getQuantity() / 100)
                .sum();
        return fromFoods + fromMeals;
    }

    public double getTotalCalories() {
        double fromFoods = foods.stream()
                .mapToDouble(rf -> rf.getFood().getCalories() * rf.getQuantity() / 100)
                .sum();
        double fromMeals = meals.stream()
                .mapToDouble(rm -> rm.getMeal().getCalories() * rm.getQuantity() / 100)
                .sum();
        return fromFoods + fromMeals;
    }
}