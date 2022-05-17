package com.github.servbytebackend.data.repository;

import com.github.servbytebackend.data.enums.City;
import com.github.servbytebackend.data.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


    List<Restaurant> findByCity(City city);
}
