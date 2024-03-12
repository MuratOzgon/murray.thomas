package com.challenge.murray.thomas.mapper;
import com.challenge.murray.thomas.model.Meal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MealMapper {
    void insertMeal(Meal meal);
    List<Meal> findMealsByUserId(Long userId);
    void updateMeal(Meal meal);
    void deleteMealById(Long id);
}