package com.github.servbytebackend.web.controller;


import com.github.servbytebackend.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="api/v1")
@RequiredArgsConstructor
public class RestaurantController {

    public final RestaurantService restaurantService;


    @GetMapping(value="/")
    public ResponseEntity<?> getRestaurantsByCity(String city){
        return new ResponseEntity<>(restaurantService.getRestaurantsByCity(city), HttpStatus.FOUND);
    }
}
