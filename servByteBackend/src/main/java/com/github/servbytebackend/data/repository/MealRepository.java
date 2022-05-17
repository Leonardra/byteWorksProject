package com.github.servbytebackend.data.repository;

import com.github.servbytebackend.data.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

}
