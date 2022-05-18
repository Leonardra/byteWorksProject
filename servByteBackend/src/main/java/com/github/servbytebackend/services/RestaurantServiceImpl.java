package com.github.servbytebackend.services;


import com.github.servbytebackend.data.enums.City;
import com.github.servbytebackend.data.model.Restaurant;
import com.github.servbytebackend.data.repository.RestaurantRepository;
import com.github.servbytebackend.exceptions.ApplicationException;
import com.github.servbytebackend.exceptions.CityNotFoundException;
import com.github.servbytebackend.web.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public ApiResponse getRestaurantsByCity(String cityStr) {
        City city;
        try {
            city = City.valueOf(cityStr.toUpperCase());
        }catch(IllegalArgumentException ex){
            throw new CityNotFoundException("This restaurant is not in this city");
        }
        ApiResponse response = new ApiResponse();
        List<Restaurant> restaurants =  restaurantRepository.findByCity(city);
        response.setStatus("Success");
        response.getData().put("restaurants", restaurants);
        response.getData().put("totalNumberOfRestaurants", restaurants.size());
        return response;
    }

    @Override
    public ApiResponse getAll() {
        ApiResponse apiResponse = new ApiResponse();
        List<Restaurant> restaurants = restaurantRepository.findAll();
        apiResponse.setStatus("success");
        apiResponse.getData().put("totalNumberOfRestaurants", restaurants.size());
        apiResponse.getData().put("restaurant", restaurantRepository.findAll());
        return apiResponse;
    }
}
