import React, {useEffect, useState} from 'react';
import {Card, CardActionArea, CardContent, CardMedia, Container, Grid, Stack, Typography} from "@mui/material";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import SingleMeal from "./SingleMealCard";

const SingleRestaurantPage = () => {

    const navigate = useNavigate();
    const {id} = useParams()


    const[restaurant, getRestaurant] = useState({});
    const[meals, getMeals] = useState([])

    const url = "http://localhost:8081/api/v1/restaurant/"
    const getAllRestaurant =  () =>{
        axios.get(`${url}${id}`).then((response) =>{
            console.log("Response",response);
            const allRestaurants = response.data.data.restaurant;
            getRestaurant(allRestaurants)
            console.log("Restaurants ->", allRestaurants)
        }).catch(error => console.error(`Error: ${error}`))
    }


    const getAllMealsFromRestaurant = () =>{
        axios.get(`${url}${id}/meals`).then((response) => {
            console.log("Response -> ", response)
            const allMeals = response.data.data.meals;
            getMeals(allMeals);
            console.log("Meals -> ", allMeals)
        }).catch((err) => {console.log(`Error -> ${err}`)})
    }

    useEffect(
        () => {
            getAllRestaurant();
        }, []
    )

    useEffect(() =>
    {
        getAllMealsFromRestaurant();
    }, [])

    return (
        <Container>
            <Stack marginTop="4rem" direction="column" spacing={7}>
                <Card elevation="0">
                    <CardMedia
                        component="img"
                        height="400"
                        image={restaurant.logoUrl}
                        alt={restaurant.restaurantName}>

                    </CardMedia>
                </Card>

                <Stack direction="column"
                       alignItems="center"
                       justifyContent="center">
                    <Typography
                        fontSize="34px" fontWeight="500" color="#210a72"
                    >{restaurant.restaurantName}</Typography>
                    <Typography alignItems="center">{restaurant.description}
                    </Typography>
                </Stack>

                <Stack>
                    <Typography>Meals</Typography>
                    <Grid spacing={5} container lg={12}>
                        {meals.map(meal =>
                            <SingleMeal  key={meal.id} meal={meal}/>
                        )}

                    </Grid>
                </Stack>
            </Stack>
        </Container>
    );
};

export default SingleRestaurantPage;