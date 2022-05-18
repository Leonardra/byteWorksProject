import React, {useState, useEffect} from 'react';
import {Button, Card, CardMedia, Container, Stack, Typography} from "@mui/material";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";

const SingleMealPage = () => {

    const navigate = useNavigate();
    const {id} = useParams()
    const[meal, getMeal] = useState({});

    const url = "http://localhost:8081/api/v1/meal/"
    const getSingleMeal =  () =>{
        axios.get(`${url}${id}`).then((response) =>{
            console.log("Response",response);
            const singleMeal = response.data.data.meals;
            getMeal(singleMeal)
            console.log("Meal ->", singleMeal)
        }).catch(error => console.error(`Error: ${error}`))
    }



    useEffect(
        () => {
            getSingleMeal();
        }, []
    )

    return (
        <Container>
            <Stack direction="row" spacing={5}>
                <Card elevation="0" >
                    <CardMedia
                        component="img"
                        height="400"
                        width="25rem"
                        image={meal.imageUrl}
                        alt={meal.mealName}>
                    </CardMedia>

                    <Stack direction="column">
                        <Typography
                            fontSize="34px" fontWeight="500" color="#210a72"
                        >{meal.mealName}</Typography>

                        <Typography fontSize="35px" fontWeight="500" color="#210a72">Preparation Time: {meal.preparationTimeInMinutes} Minutes</Typography>

                        <Typography fontSize="45px" fontWeight="300" color="#210a72"> {meal.description}</Typography>

                        <Typography fontSize="35px" fontWeight="500" color="#210a72">Price: {meal.price}</Typography>

                        <Button  variant="contained" fullWidth type="submit" sx={{ background: "#210a72", height: 60 }}>Order Now</Button>
                    </Stack>
                </Card>
            </Stack>
        </Container>
    );
};

export default SingleMealPage;