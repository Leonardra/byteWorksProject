import React, {useState, useEffect} from 'react';
import {Button, Card, CardMedia, Container, Grid, Stack, Typography} from "@mui/material";
import {Link, useNavigate, useParams} from "react-router-dom";
import axios from "axios";

const SingleMealPage = () => {

    const {id} = useParams()
    const[meal, getMeal] = useState({});
    const navigate = useNavigate();

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

                        <Stack marginTop="10rem" direction="row"  alignItems="center" justifyContent="center">
                            <Stack marginRight="2.5rem">
                                <Grid lg={4}>
                                    <Card elevation="0" >
                                        <CardMedia>
                                            <img src={meal.imageUrl} style={{width: '600px', height: '400px'}} alt={meal.mealName}/>
                                        </CardMedia>
                                    </Card>
                                </Grid>
                            </Stack>
                            <Stack>
                                <Grid lg={6}>
                                    <Stack direction="column" spacing={3}>
                                        <Typography
                                            fontSize="34px" fontWeight="700" color="#210a72"
                                        >{meal.mealName}</Typography>

                                        <Typography fontSize="20px" fontWeight="500" color="#210a72">Preparation Time: {meal.preparationTimeInMinutes} Minutes</Typography>

                                        <Typography fontSize="20px" fontWeight="300" color="#210a72"> {meal.description}</Typography>

                                        <Typography fontSize="20px" fontWeight="500" color="#210a72">Price: {meal.price}</Typography>


                                        <Link to={`/paymentPage/${meal.price}`} style={{backgroundColor: "#210a72",
                                            height:"2rem",
                                            width: "6rem",
                                            color: "white",
                                            textDecoration:"none",
                                            padding:"1rem",
                                            alignItems:"center",
                                            justifyContent:"center",
                                            borderRadius:"0.5rem"
                                        }}>Order Now</Link>

                                    </Stack>
                                </Grid>
                            </Stack>


                        </Stack>

        </Container>

    );
};

export default SingleMealPage;