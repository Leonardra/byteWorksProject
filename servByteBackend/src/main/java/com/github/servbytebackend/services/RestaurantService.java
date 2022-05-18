package com.github.servbytebackend.services;

import com.github.servbytebackend.data.model.Restaurant;
import com.github.servbytebackend.web.payload.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    ApiResponse getRestaurantsByCity(String city);
    ApiResponse getAll();
    ApiResponse getRestaurantById(Long id);
}
