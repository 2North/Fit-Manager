package com.example.fitmanager.repository;

import com.example.fitmanager.model.RecordFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordFoodRepository extends JpaRepository<RecordFood, Long> {
}