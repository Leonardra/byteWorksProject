package com.github.servbytebackend.services;

import com.github.servbytebackend.data.enums.City;
import com.github.servbytebackend.data.model.Restaurant;
import com.github.servbytebackend.data.repository.RestaurantRepository;
import com.github.servbytebackend.exceptions.CityNotFoundException;
import com.github.servbytebackend.web.payload.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class RestaurantServiceImplTest {


    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RestaurantService restaurantService;

    @Test
    void testThatRestaurantCanBeSearchedByCity(){
        ApiResponse restaurantResponse = restaurantService.getRestaurantsByCity("lagos");
        assertEquals(restaurantResponse.getData().get("totalNumberOfRestaurants"), 7);
    }

    @Test
    void testThatExceptionIsThrownIfCityDoesNotExist(){
        assertThrows(CityNotFoundException.class, ()-> restaurantService.getRestaurantsByCity("abakaliki"));
    }

    @Test
    void testRepositoryCanGetAllRestaurants(){
        ApiResponse restaurantResponse = restaurantService.getAll();
        assertEquals(restaurantResponse.getData().get("totalNumberOfRestaurants"), 10);
    }

}