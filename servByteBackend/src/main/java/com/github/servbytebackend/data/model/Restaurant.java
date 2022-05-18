package com.github.servbytebackend.data.model;


import com.github.servbytebackend.data.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private String emailAddress;
    private String phoneNumber;
    private String description;
    @Enumerated(EnumType.STRING)
    private City city;
    private String logoUrl;
}
