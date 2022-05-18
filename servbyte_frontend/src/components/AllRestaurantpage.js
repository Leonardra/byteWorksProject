import React, {useEffect, useState} from 'react';
import {
    Breadcrumbs,
    Button,
    Container,
    Grid,
    IconButton,
    InputBase,
    Link,
    Paper,
    Stack,
    Typography
} from "@mui/material";
import SearchIcon from "@material-ui/icons/Search";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import RestaurantCard from "./RestaurantCard";

const AllRestaurantPage = () => {

    const navigate = useNavigate();

    const[restaurants, getRestaurants] = useState([]);

    const url = "http://localhost:8081/api/v1/restaurants/"
    const getAllRestaurants =  () =>{
        axios.get(`${url}`).then((response) =>{
            console.log("Response",response);
            const allRestaurants = response.data.data.restaurant;
            getRestaurants(allRestaurants)
            console.log("Restaurants ->", allRestaurants)
        }).catch(error => console.error(`Error: ${error}`))
    }

    useEffect(
        () => {
            getAllRestaurants();
        }, []
    )
    return (
        <Container>

            <Stack direction="column" spacing={10} marginTop="5rem" marginBottom="5rem">

                <Breadcrumbs aria-label="breadcrumb">
                    <Link underline="hover" color="inherit" onClick={() =>navigate("/")}>
                        Home
                    </Link>
                    <Link
                        underline="hover"
                        color="inherit"
                        onClick={() => navigate("/")}
                    >
                        Category
                    </Link>
                    <Typography color="text.primary">Restaurants</Typography>
                </Breadcrumbs>
                <Stack>
                    <Paper component="form" sx={{ p: '2px 4px', display: 'flex', alignItems: 'center', width: 400 }}>
                        <InputBase sx={{ ml: 1, flex: 1 }} id="search" placeholder="Search Restaurant" />
                        <IconButton>
                            <SearchIcon/>
                        </IconButton>
                    </Paper>
                </Stack>

                <Grid spacing={5} container lg={12}>
                    {restaurants.map(restaurant =>
                        <RestaurantCard  key={restaurant.id} restaurant={restaurant}/>

                    )}
                </Grid>

                <Stack  direction="row" justifyContent="space-between">
                    <Button variant="contained" sx={{color:"#210a72", height: 60, margin:"12px"}}>Previous</Button>
                    <Button variant="contained" sx={{color:"#a5d5e4", height: 60, margin:"12px"}}>Next</Button>
                </Stack>
            </Stack>

        </Container>
    );
};

export default AllRestaurantPage;