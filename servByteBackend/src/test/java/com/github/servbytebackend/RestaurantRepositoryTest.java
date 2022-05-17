package com.github.servbytebackend;


import com.github.servbytebackend.data.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RestaurantRepositoryTest {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    void testThatRestaurantRepositoryIsNotEmpty(){
        assertFalse(restaurantRepository.findAll().isEmpty());
    }

}
