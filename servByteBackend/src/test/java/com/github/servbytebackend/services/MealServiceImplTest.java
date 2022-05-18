package com.github.servbytebackend.services;

import com.github.servbytebackend.web.payload.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MealServiceImplTest {

    @Autowired
    MealService mealService;




    @Test
    void testThatMealsCanBeGottenFromRestaurantId(){
        ApiResponse response = mealService.getMealsByRestaurant(2L);
        assertEquals(2, response.getData().get("totalNumberOfMeals"));
    }
}