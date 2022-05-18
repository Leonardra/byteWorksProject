package com.github.servbytebackend.web.controller;

import com.github.servbytebackend.data.enums.City;
import com.github.servbytebackend.data.model.Meal;
import com.github.servbytebackend.data.model.Restaurant;
import com.github.servbytebackend.exceptions.CityNotFoundException;
import com.github.servbytebackend.services.MealService;
import com.github.servbytebackend.services.RestaurantService;
import com.github.servbytebackend.web.payload.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class RestaurantControllerTest {


    @Autowired
    RestaurantController restaurantController;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RestaurantService restaurantService;

    @MockBean
    MealService mealService;



    @Test
    void testFindRestaurantsByCity() throws Exception {
        Restaurant restaurant1 = Restaurant.builder()
                .restaurantName("Cilantro")
                .city(City.LAGOS)
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
                .restaurantName("Cilantro")
                .city(City.ABUJA)
                .emailAddress("cilantro@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Cilantro_ho2vym.png")
                .phoneNumber("08076543210").build();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("success");
        apiResponse.getData().put("restaurants", List.of(restaurant1, restaurant2));
        apiResponse.getData().put("totalNumberOfRestaurants", 2);

        doReturn(apiResponse).when(restaurantService).getRestaurantsByCity("lagos");

        this.mockMvc.perform(get("/api/v1/restaurants/lagos")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath("$.data.totalNumberOfRestaurants", is(2)))
                .andExpect(jsonPath("$.data.restaurants", hasSize(2)));
    }


    @Test
    void testThatExceptionIsThrownIfCityDoesNotExist() throws Exception {
        doThrow(CityNotFoundException.class).when(restaurantService).getRestaurantsByCity("abakaliki");
        this.mockMvc.perform(get("/api/v1/restaurants/abakaliki"))
                .andDo(print())
                // test status
                .andExpect(status().isBadRequest())
                // test resolved exception
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof CityNotFoundException));
    }

    @Test
    void testGetAllRestaurants() throws Exception {
        Restaurant restaurant1 = Restaurant.builder()
                .restaurantName("Cilantro")
                .city(City.LAGOS)
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
                .restaurantName("Cilantro")
                .city(City.ABUJA)
                .emailAddress("cilantro@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Cilantro_ho2vym.png")
                .phoneNumber("08076543210").build();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("success");
        apiResponse.getData().put("restaurants", List.of(restaurant1, restaurant2, restaurant3));
        apiResponse.getData().put("totalNumberOfRestaurants", 3);

        doReturn(apiResponse).when(restaurantService).getAll();

        this.mockMvc.perform(get("/api/v1/restaurants/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath("$.data.totalNumberOfRestaurants", is(3)))
                .andExpect(jsonPath("$.data.restaurants", hasSize(3)));
    }


    @Test
    void testThatRestaurantCanBeFound() throws Exception {
        Restaurant restaurant1 = Restaurant.builder()
                .id(1L)
                .restaurantName("Cilantro")
                .city(City.LAGOS)
                .emailAddress("cilantro@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Cilantro_ho2vym.png")
                .phoneNumber("08076543210").build();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("success");
        apiResponse.getData().put("restaurant", restaurant1);

        doReturn(apiResponse).when(restaurantService).getRestaurantById(1L);

        this.mockMvc.perform(get("/api/v1/restaurant/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath("$.data.restaurant.restaurantName", is("Cilantro")));
    }


    @Test
    void testThatMealsCanBeFoundByRestaurantId() throws Exception {

        Restaurant restaurant1 = Restaurant.builder()
                .id(1L)
                .restaurantName("Cilantro")
                .city(City.LAGOS)
                .emailAddress("cilantro@gmail.com")
                .logoUrl("https://res.cloudinary.com/inclutab/image/upload/v1652788441/servByte/restaurant/Cilantro_ho2vym.png")
                .phoneNumber("08076543210").build();


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


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("success");
        apiResponse.getData().put("meals", List.of(meal1, meal2));
        apiResponse.getData().put("totalNumberOfMeals", 2);

        doReturn(apiResponse).when(mealService).getMealsByRestaurant(1L);

        this.mockMvc.perform(get("/api/v1/restaurant/1/meals")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath("$.data.totalNumberOfMeals", is(2)));
    }
}