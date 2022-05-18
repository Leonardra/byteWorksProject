package com.github.servbytebackend.services;

import com.github.servbytebackend.data.model.Meal;
import com.github.servbytebackend.data.repository.MealRepository;
import com.github.servbytebackend.exceptions.MealNotExistException;
import com.github.servbytebackend.web.payload.ApiResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService{

    private final MealRepository mealRepository;


    @Override
    public ApiResponse getMealsByRestaurant(Long id) {
        ApiResponse apiResponse = new ApiResponse();
        List<Meal> meals = mealRepository.findAllMealByRestaurantId(id);
        apiResponse.setStatus("success");
        apiResponse.getData().put("meals", meals);
        apiResponse.getData().put("totalNumberOfMeals", meals.size());
        return apiResponse;
    }

    @Override
    public ApiResponse getMealsById(Long id) {
        ApiResponse apiResponse = new ApiResponse();
        Optional<Meal> optionalMeal = mealRepository.findById(id);
        if(optionalMeal.isPresent()){
            apiResponse.setStatus("success");
            apiResponse.getData().put("meals",optionalMeal.get());
            return apiResponse;
        }
        throw new MealNotExistException("This Meal does not exist");
    }
}
