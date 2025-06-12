package com.example.fitmanager.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class NutritionEntryForm {

    private Long userId;

    private Long foodId;

    private Long mealId;

    private double quantity;

    private LocalDate date;
}