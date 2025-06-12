package com.example.fitmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "record_food")
public class RecordFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "record_id", nullable = false)
    private DailyRecord dailyRecord;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @Column(nullable = false)
    private double quantity; // Количество в граммах
}