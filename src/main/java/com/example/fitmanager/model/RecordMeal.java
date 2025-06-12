package com.example.fitmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "record_meal")
public class RecordMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "record_id", nullable = false)
    private DailyRecord dailyRecord;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @Column(nullable = false)
    private double quantity; // Количество в граммах
}