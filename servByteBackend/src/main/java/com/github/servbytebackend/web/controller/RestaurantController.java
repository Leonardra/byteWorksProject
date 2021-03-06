package com.github.servbytebackend.web.controller;


import com.github.servbytebackend.services.MealService;
import com.github.servbytebackend.services.RestaurantService;
import com.github.servbytebackend.web.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value ="api/v1")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    public final RestaurantService restaurantService;
    private final MealService mealService;


    @GetMapping(value="/restaurants/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getRestaurantsByCity(@PathVariable String city){
        return restaurantService.getRestaurantsByCity(city);
    }


    @GetMapping(value="/restaurants/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getRestaurants(@RequestParam(defaultValue = "") String city){
        if (city.isEmpty())
            return restaurantService.getAll();
        return restaurantService.getRestaurantsByCity(city);
    }


    @GetMapping(value="/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getRestaurantById(@PathVariable Long id){
        return restaurantService.getRestaurantById(id);
    }


    @GetMapping(value="/restaurant/{id}/meals")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getMealsByRestaurant(@PathVariable Long id){
        return mealService.getMealsByRestaurant(id);
    }


    @GetMapping(value="/meal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getMealById(@PathVariable Long id){
        return mealService.getMealsById(id);
    }

}
