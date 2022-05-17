package com.github.servbytebackend;


import com.github.servbytebackend.data.repository.MealRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class MealRepositoryTest {
    @Autowired
    MealRepository mealRepository;

    @Test
    void testThatMealRepositoryIsNotEmpty(){
        assertFalse(mealRepository.findAll().isEmpty());
    }
}
