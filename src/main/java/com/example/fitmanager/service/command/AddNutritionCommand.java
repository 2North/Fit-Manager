package com.example.fitmanager.service.command;

import com.example.fitmanager.model.*;
import com.example.fitmanager.repository.*;

public class AddNutritionCommand implements Command {
    private DailyRecord dailyRecord;
    private NutritionItem item;
    private double quantity;
    private RecordFoodRepository foodRepo;
    private RecordMealRepository mealRepo;

    public AddNutritionCommand(DailyRecord record, NutritionItem item, double quantity,
                               RecordFoodRepository foodRepo, RecordMealRepository mealRepo) {
        this.dailyRecord = record;
        this.item = item;
        this.quantity = quantity;
        this.foodRepo = foodRepo;
        this.mealRepo = mealRepo;
    }

    @Override
    public void execute() {
        if (item instanceof Food) {
            RecordFood recordFood = new RecordFood();
            recordFood.setDailyRecord(dailyRecord);
            recordFood.setFood((Food) item);
            recordFood.setQuantity(quantity);
            foodRepo.save(recordFood);
            dailyRecord.getFoods().add(recordFood);
        } else if (item instanceof Meal) {
            RecordMeal recordMeal = new RecordMeal();
            recordMeal.setDailyRecord(dailyRecord);
            recordMeal.setMeal((Meal) item);
            recordMeal.setQuantity(quantity);
            mealRepo.save(recordMeal);
            dailyRecord.getMeals().add(recordMeal);
        }
    }

    @Override
    public void undo() {
        if (item instanceof Food) {
            dailyRecord.getFoods().removeIf(rf -> rf.getFood().equals(item) && rf.getQuantity() == quantity);
        } else if (item instanceof Meal) {
            dailyRecord.getMeals().removeIf(rm -> rm.getMeal().equals(item) && rm.getQuantity() == quantity);
        }
    }
}
