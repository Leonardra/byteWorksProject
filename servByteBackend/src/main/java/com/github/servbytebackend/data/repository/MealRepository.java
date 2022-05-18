package com.github.servbytebackend.data.repository;

import com.github.servbytebackend.data.model.Meal;
import com.github.servbytebackend.data.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findAllMealByRestaurantId(Long id);
}
