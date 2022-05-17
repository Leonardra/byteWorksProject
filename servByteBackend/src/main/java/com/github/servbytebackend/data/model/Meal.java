package com.github.servbytebackend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mealName;
    private String imageUrl;
    private BigDecimal price;
    private int preparationTimeInMinutes;
    private String description;
    @ManyToOne
    private Restaurant restaurant;
}
