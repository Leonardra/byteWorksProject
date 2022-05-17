package com.github.servbytebackend.services;

import com.github.servbytebackend.data.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    List<Restaurant> getRestaurantsByCity();
}
