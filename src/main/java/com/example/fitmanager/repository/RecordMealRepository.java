package com.example.fitmanager.repository;

import com.example.fitmanager.model.RecordMeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordMealRepository extends JpaRepository<RecordMeal, Long> {
}