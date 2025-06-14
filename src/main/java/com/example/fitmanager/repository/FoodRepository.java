// FoodRepository.java
package com.example.fitmanager.repository;

import com.example.fitmanager.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String name);
}