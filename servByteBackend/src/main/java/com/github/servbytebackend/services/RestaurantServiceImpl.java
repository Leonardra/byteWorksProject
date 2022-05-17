package com.github.servbytebackend.services;


import com.github.servbytebackend.data.enums.City;
import com.github.servbytebackend.data.model.Restaurant;
import com.github.servbytebackend.data.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getRestaurantsByCity(String cityStr) {
        City city = City.valueOf(cityStr.toUpperCase());
        return restaurantRepository.findByCity(city);
    }
}
