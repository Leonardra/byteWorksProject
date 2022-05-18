package com.github.servbytebackend.services;

import com.github.servbytebackend.data.model.Meal;
import com.github.servbytebackend.data.repository.MealRepository;
import com.github.servbytebackend.web.payload.ApiResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
