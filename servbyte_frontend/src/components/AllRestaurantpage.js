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
    const [city, setCity] = useState("");
    const [searchTerm, setSearchTerm] = useState("");
    const [error, setError] = useState(null);

    const[restaurants, getRestaurants] = useState([]);

    const handleSearchByCity = (e) => {

        setCity(e.target.value)
    }
    const handleSearch = () => {
        setError(null)
        setSearchTerm(city)
    }
    useEffect(
        () => {
            const url = `http://localhost:8081/api/v1/restaurants/?city=${searchTerm}`
            axios.get(`${url}`).then((response) =>{
                console.log("Response",response);
                const allRestaurants = response.data.data.restaurant || response.data.data.restaurants;
                getRestaurants(allRestaurants)
                console.log("Restaurants ->", allRestaurants)
            }).catch(error => {console.error(`Error: ${error}`); setError(error);})
        }, [searchTerm]
    )


    return (
        <Container>

            <Stack direction="column" spacing={10} marginTop="5rem" marginBottom="5rem">

                <Breadcrumbs aria-label="breadcrumb">
                    <Link underline="hover" color="inherit" onClick={() => navigate("/")}>
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
                    <Paper component="form" sx={{p: '2px 4px', display: 'flex', alignItems: 'center', width: 400}}>
                        <InputBase sx={{ml: 1, flex: 1}} id="search" placeholder="Search Restaurant" value={city}
                                   onChange={handleSearchByCity}/>
                        <IconButton
                            onClick={handleSearch}
                        >
                            <SearchIcon/>
                        </IconButton>
                    </Paper>
                </Stack>

                <Grid spacing={5} container lg={12}>
                    {error ? <Typography
                            fontWeight="200"
                            color="#d3d3d3"
                            fontSize="50px"
                            sx={{
                                transition: "font-size 0.5s ease",
                                pointer: "cursor",
                                "&:hover": {
                                    color: "#000",
                                    fontWeight: "300"
                                },
                            }}>City with name '{searchTerm}' does not exist </Typography> :

                        restaurants.map(restaurant =>
                            <RestaurantCard key={restaurant.id} restaurant={restaurant}/>
                        )

                    }
                </Grid>

                <Stack direction="row" justifyContent="space-between">
                    <Button variant="contained"
                            sx={{color: "#210a72", height: 60, margin: "12px"}}>Previous</Button>
                    <Button variant="contained" sx={{color: "#a5d5e4", height: 60, margin: "12px"}}>Next</Button>
                </Stack>
            </Stack>

        </Container>
    );
};

export default AllRestaurantPage;