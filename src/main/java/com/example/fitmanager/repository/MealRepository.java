// MealRepository.java
package com.example.fitmanager.repository;

import com.example.fitmanager.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}