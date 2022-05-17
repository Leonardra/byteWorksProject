package com.github.servbytebackend.config;


import com.github.servbytebackend.data.enums.City;
import com.github.servbytebackend.data.model.Meal;
import com.github.servbytebackend.data.model.Restaurant;
import com.github.servbytebackend.data.repository.MealRepository;
import com.github.servbytebackend.data.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitialiseDatabase {

    private final RestaurantRepository restaurantRepository;
    private final MealRepository mealRepository;

    @PostConstruct
    public void initialiseDatabase(){
        Restaurant restaurant1 = Restaurant.builder()
                .restaurantName("Cilantro")
                .city(City.ABUJA)
                .emailAddress("cilantro@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Cilantro_ho2vym.png")
                .phoneNumber("08076543210").build();

        Restaurant restaurant2 = Restaurant.builder()
                .restaurantName("Crunchies")
                .city(City.LAGOS)
                .emailAddress("crunchiesng@yahoo.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Crunchies_jl7sbn.png")
                .phoneNumber("09068685949")
                .build();

        Restaurant restaurant3 = Restaurant.builder()
                .restaurantName("The Real Jollof Co.")
                .city(City.LAGOS)
                .emailAddress("thejollofco@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_Real_Jollof_Co_aeeny5.png")
                .phoneNumber("09126363732")
                .build();

        Restaurant restaurant4 = Restaurant.builder()
                .restaurantName("The Place")
                .city(City.ASABA)
                .emailAddress("theplace@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_place_jxuckq.png")
                .phoneNumber("091263637880")
                .build();

        Restaurant restaurant5 = Restaurant.builder()
                .restaurantName("The Place")
                .city(City.LAGOS)
                .emailAddress("theplace@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_place_jxuckq.png")
                .phoneNumber("091263637880")
                .build();

        Restaurant restaurant6 = Restaurant.builder()
                .restaurantName("Taste Nigeria")
                .city(City.OWERRI)
                .emailAddress("tasteng@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/TasteNg_ppjsiw.png")
                .phoneNumber("08123737738")
                .build();

        Restaurant restaurant7 = Restaurant.builder()
                .restaurantName("Mount Holly")
                .city(City.LAGOS)
                .emailAddress("mountholly@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788443/servByte/restaurant/Mount_Holly_shcw5i.png")
                .phoneNumber("07034532265")
                .build();

        Restaurant restaurant8 = Restaurant.builder()
                .restaurantName("The Real Jollof Co.")
                .city(City.LAGOS)
                .emailAddress("thejollofco@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_Real_Jollof_Co_aeeny5.png")
                .phoneNumber("09126363732")
                .build();

        Restaurant restaurant9 = Restaurant.builder()
                .restaurantName("The Real Jollof Co.")
                .city(City.LAGOS)
                .emailAddress("thejollofco@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_Real_Jollof_Co_aeeny5.png")
                .phoneNumber("09126363732")
                .build();

        Restaurant restaurant10 = Restaurant.builder()
                .restaurantName("The Real Jollof Co.")
                .city(City.LAGOS)
                .emailAddress("thejollofco@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788444/servByte/restaurant/The_Real_Jollof_Co_aeeny5.png")
                .phoneNumber("09126363732")
                .build();


        List<Restaurant> restaurants = List.of(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5,
                restaurant6, restaurant7, restaurant8, restaurant9, restaurant10);

        Meal meal1 = Meal.builder().mealName("Jollof Rice").description("Jollof, or jollof rice, is a rice dish from " +
                "Senegal. The dish is typically made with long-grain rice, tomatoes, onions, spices, vegetables and " +
                "meat in a single pot, although its ingredients and preparation methods vary across different regions")
                .imageUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/2_ik2r6f.jpg")
                .preparationTimeInMinutes(30)
                .price(BigDecimal.valueOf(20000.0))
                .restaurant(restaurant1).build();

        Meal meal2 = Meal.builder().mealName("Gizdodo").description("Gizdodo is the combination of plantains and " +
                        "Gizzards  (chicken Gizzards) and Plantains mixed in Pepper Sauce. This recipe is great for " +
                        "mid-week or weekend dinner because it’s so straightforward and of course tasty.")
                .imageUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788791/servByte/Meals/7_ofuhct.jpg")
                .preparationTimeInMinutes(20)
                .price(BigDecimal.valueOf(8000.0))
                .restaurant(restaurant1).build();

        Meal meal3 = Meal.builder().mealName("Semo and Egusi").description("The soup is made with pieces of beef, " +
                        "ponmo, goat meat, dry fish and stockfish. Medium heat and very tasty too. " +
                        "This is a perfect meal combo for swallow lovers!")
                .imageUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/4_px9t0w.jpg")
                .preparationTimeInMinutes(30)
                .price(BigDecimal.valueOf(15000.0))
                .restaurant(restaurant2).build();

        Meal meal4 = Meal.builder().mealName("Jollof Rice").description("Jollof, or jollof rice, is a rice dish from " +
                        "Senegal. The dish is typically made with long-grain rice, tomatoes, onions, spices, vegetables and " +
                        "meat in a single pot, although its ingredients and preparation methods vary across different regions")
                .imageUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/2_ik2r6f.jpg")
                .preparationTimeInMinutes(30)
                .price(BigDecimal.valueOf(20000.0))
                .restaurant(restaurant2).build();

        Meal meal5 = Meal.builder().mealName("Jollof Rice").description("Jollof, or jollof rice, is a rice dish from " +
                        "Senegal. The dish is typically made with long-grain rice, tomatoes, onions, spices, vegetables and " +
                        "meat in a single pot, although its ingredients and preparation methods vary across different regions")
                .imageUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/2_ik2r6f.jpg")
                .preparationTimeInMinutes(30)
                .price(BigDecimal.valueOf(20000.0))
                .restaurant(restaurant3).build();

        Meal meal6 = Meal.builder().mealName("Jollof Rice").description("Jollof, or jollof rice, is a rice dish from " +
                        "Senegal. The dish is typically made with long-grain rice, tomatoes, onions, spices, vegetables and " +
                        "meat in a single pot, although its ingredients and preparation methods vary across different regions")
                .imageUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/2_ik2r6f.jpg")
                .preparationTimeInMinutes(30)
                .price(BigDecimal.valueOf(20000.0))
                .restaurant(restaurant5).build();

        Meal meal7 = Meal.builder().mealName("Jollof Rice").description("Jollof, or jollof rice, is a rice dish from " +
                        "Senegal. The dish is typically made with long-grain rice, tomatoes, onions, spices, vegetables and " +
                        "meat in a single pot, although its ingredients and preparation methods vary across different regions")
                .imageUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788792/servByte/Meals/2_ik2r6f.jpg")
                .preparationTimeInMinutes(30)
                .price(BigDecimal.valueOf(20000.0))
                .restaurant(restaurant10).build();

        List<Meal> meals = List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7);

        mealRepository.saveAll(meals);

        restaurantRepository.saveAll(restaurants);
    }
}
