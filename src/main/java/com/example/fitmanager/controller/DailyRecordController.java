package com.example.fitmanager.controller;

import com.example.fitmanager.model.DailyRecord;
import com.example.fitmanager.model.Food;
import com.example.fitmanager.model.Meal;
import com.example.fitmanager.model.NutritionItem;
import com.example.fitmanager.repository.DailyRecordRepository;
import com.example.fitmanager.repository.FoodRepository;
import com.example.fitmanager.repository.MealRepository;
import com.example.fitmanager.service.NutritionCollection;
import com.example.fitmanager.service.NutritionIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/daily-records")
public class DailyRecordController {
    @Autowired
    private FoodRepository foodRepo;
    @Autowired
    private MealRepository mealRepo;

    @GetMapping
    public String showMealRecords(Model model) {
        // Получаем все продукты и блюда из БД
        List<NutritionItem> foods = new ArrayList<>(foodRepo.findAll());
        List<NutritionItem> meals = new ArrayList<>(mealRepo.findAll());

        // Объединяем в одну коллекцию
        List<NutritionItem> allItems = new ArrayList<>();
        allItems.addAll(foods);
        allItems.addAll(meals);

        // Создаем итератор
        NutritionCollection collection = new NutritionCollection(allItems);
        NutritionIterator iterator = collection.createIterator();



        // Передаем элементы в Thymeleaf
        model.addAttribute("nutritionItems", allItems); // Для простоты, можно и итератор
        return "daily-records";
    }
}