import React from 'react';
import {
    Breadcrumbs, Button,
    Card,
    CardActionArea, CardContent, CardMedia,
    Container,
    Grid,
    IconButton,
    InputBase,
    Link,
    Paper,
    Stack,
    Typography
} from "@mui/material";
import SearchIcon from '@material-ui/icons/Search';
import { useNavigate } from "react-router-dom";

const RestaurantResultPage = () => {

    const navigate = useNavigate();
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
                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>

                    <Grid
                        item lg={4} spacing={10}
                    >
                        <Card sx={{ maxWidth: 345, backgroundColor:"#a5d5e4" }} onClick={()=>navigate("/single")}>
                            <CardActionArea>
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image="https://picsum.photos/200/300"
                                    alt="green iguana"
                                />
                                <CardContent >
                                    <Typography gutterBottom variant="h5" component="div" color="#210a72">
                                        Lizard
                                    </Typography>
                                    <Typography variant="body2" color="text.secondary" color="#210a72">
                                        Lizards are a widespread group of squamate reptiles, with over 6,000
                                        species, ranging across all continents except Antarctica
                                    </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Grid>
                </Grid>

                <Stack  direction="row" justifyContent="space-between">
                    <Button variant="contained" sx={{color:"#210a72", height: 60, margin:"12px"}}>Previous</Button>
                    <Button variant="contained" sx={{color:"#a5d5e4", height: 60, margin:"12px"}}>Next</Button>
                </Stack>
            </Stack>

        </Container>
    );
};

export default RestaurantResultPage;