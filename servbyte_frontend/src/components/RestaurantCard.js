import React from 'react';
import {Card, CardActionArea, CardContent, CardMedia, Grid, Typography} from "@mui/material";
import { useNavigate } from "react-router-dom";

const RestaurantCard = ({restaurant}) => {

    const navigate = useNavigate();
    return (
        <Grid
            item lg={4} spacing={10}
        >
            <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate(`/single/${restaurant.id}`)}>
                <CardActionArea>
                    <CardMedia
                        component="img"
                        height="140"
                        image={restaurant.logoUrl}
                        alt="green iguana"
                    />
                    <CardContent >
                        <Typography gutterBottom variant="h5" component="div" color="#210a72">
                            {restaurant.restaurantName}
                        </Typography>
                        <Typography variant="body2" color="text.secondary" color="#210a72">
                            {restaurant.description}
                        </Typography>
                    </CardContent>
                </CardActionArea>
            </Card>
        </Grid>
    );
};

export default RestaurantCard;