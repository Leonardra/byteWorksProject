package com.github.servbytebackend.services;


import com.github.servbytebackend.data.model.Restaurant;
import com.github.servbytebackend.web.payload.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface MealService {

    ApiResponse getMealsByRestaurant(Long id);
    ApiResponse getMealsById(Long id);
}
