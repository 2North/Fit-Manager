package com.example.fitmanager.controller;

import com.example.fitmanager.service.CalorieCalculator;
import com.example.fitmanager.service.HarrisBenedictStrategy;
import com.example.fitmanager.service.MifflinStJeorStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tools")
public class ToolsController {

    private final CalorieCalculator calculator = new CalorieCalculator();

    @GetMapping
    public String showTools(Model model) {
        model.addAttribute("result", null);
        return "tools";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double weight,
            @RequestParam double height,
            @RequestParam int age,
            @RequestParam String gender,
            @RequestParam double activityLevel,
            @RequestParam String formula,
            Model model
    ) {
        // Выбор стратегии
        if ("mifflin".equals(formula)) {
            calculator.setStrategy(new MifflinStJeorStrategy());
        } else {
            calculator.setStrategy(new HarrisBenedictStrategy());
        }

        double calories = calculator.executeCalculation(weight, height, age, gender, activityLevel);
        model.addAttribute("result", Math.round(calories));
        return "tools";
    }
}