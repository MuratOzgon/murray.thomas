package com.challenge.murray.thomas.controller;

import com.challenge.murray.thomas.model.Meal;
import com.challenge.murray.thomas.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public void addMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
    }

    @PutMapping("/{id}")
    public void updateMeal(@PathVariable Long id, @RequestBody Meal meal) {
        meal.setId(id);
        mealService.updateMeal(meal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMealById(@PathVariable Long id) {
        mealService.deleteMealById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Meal> getMealsByUserId(@PathVariable Long userId) {
        return mealService.getMealsByUserId(userId);
    }
}
