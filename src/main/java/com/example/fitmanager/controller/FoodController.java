package com.example.fitmanager.controller;

import com.example.fitmanager.service.FoodBuilder;
import com.example.fitmanager.model.Food;
import com.example.fitmanager.repository.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/foods")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // Форма + список продуктов
    @GetMapping
    public String showFoods(Model model) {
        model.addAttribute("foods", foodRepository.findAll());
        model.addAttribute("newFood", new Food()); // Для формы
        return "foods";
    }

    // Создание продукта через Builder
    @PostMapping
    public String addFood(
            @RequestParam String name,
            @RequestParam double proteins,
            @RequestParam double fats,
            @RequestParam double carbs,
            @RequestParam double calories,
            Model model
    ) {
        Food food = new FoodBuilder()
                .setName(name)
                .setProteins(proteins)
                .setFats(fats)
                .setCarbs(carbs)
                .setCalories(calories)
                .build();

        foodRepository.save(food);
        return "redirect:/foods"; // Обновляем страницу
    }
}