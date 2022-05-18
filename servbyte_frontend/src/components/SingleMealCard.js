import React from 'react';
import {Card, CardActionArea, CardContent, CardMedia, Grid, Typography} from "@mui/material";
import {useNavigate} from "react-router-dom";

const SingleMealCard = ({meal}) => {

    const navigate = useNavigate();
    return (
        <Grid
            item lg={4} spacing={10}
        >
            <Card sx={{ maxWidth: 345, maxHeight: 560, backgroundColor:"#a5d5e4" }} onClick={()=> navigate(`/mealPage/${meal.id}`)}>
                <CardActionArea>
                    <CardMedia
                        component="img"
                        height="140"
                        image={meal.imageUrl}
                        alt={meal.mealName}
                    />
                    <CardContent >
                        <Typography gutterBottom variant="h5" component="div" color="#210a72">
                            {meal.mealName}
                        </Typography>
                        <Typography variant="body2" color="text.secondary" color="#210a72">
                            {meal.description}
                        </Typography>
                    </CardContent>
                </CardActionArea>
            </Card>
        </Grid>
    );
};

export default SingleMealCard;