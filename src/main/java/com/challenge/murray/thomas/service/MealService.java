package com.challenge.murray.thomas.service;

import com.challenge.murray.thomas.mapper.MealMapper;
import com.challenge.murray.thomas.model.Meal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MealService {

    private final MealMapper mealMapper;

    public MealService(MealMapper mealMapper) {
        this.mealMapper = mealMapper;
    }

    @Transactional
    public void addMeal(Meal meal) {
        mealMapper.insertMeal(meal);
    }

    public List<Meal> getMealsByUserId(Long userId) {
        return mealMapper.findMealsByUserId(userId);
    }

    @Transactional
    public void updateMeal(Meal meal) {
        mealMapper.updateMeal(meal);
    }

    @Transactional
    public void deleteMealById(Long id) {
        mealMapper.deleteMealById(id);
    }
}