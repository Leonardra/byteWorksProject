package com.github.servbytebackend.web.controller;


import com.github.servbytebackend.exceptions.CityNotFoundException;
import com.github.servbytebackend.services.RestaurantService;
import com.github.servbytebackend.web.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="api/v1")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    public final RestaurantService restaurantService;


    @GetMapping(value="/restaurants/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse getRestaurantsByCity(@PathVariable String city){
        return restaurantService.getRestaurantsByCity(city);
    }
}
