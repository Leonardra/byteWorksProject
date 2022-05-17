import React from 'react';
import {Container, Grid, Stack, Typography} from "@mui/material";
import { useNavigate } from 'react-router-dom';

const LandingPage = () => {

    const navigate = useNavigate();
    return (
        <Container sx={{ mt: "156px" }}>
            <Stack direction="column" spacing={2} alignItems="center">
                <Typography fontSize="50px" fontWeight="700" color="#210a72">Endless Categories</Typography>
                <Typography>The #1 marketplace in Africa</Typography>
            </Stack>
            <Stack direction="column" spacing={5} marginTop="2rem" onClick={() => navigate("/search")}>
                <Grid spacing={5} container lg={12} >
                    <Grid item lg={6} spacing={10} >
                        <Stack direction ="column" backgroundColor="#57f1b1" sx={{ maxWidth: 745}} height="10rem"
                               borderRadius="0.5rem" alignItems="center" justifyContent="center">
                            <Typography fontSize="34px" fontWeight="500" color="#210a72">
                                Food
                            </Typography>
                        </Stack>
                    </Grid>
                    <Grid item lg={6} spacing={10} >
                        <Stack direction ="column" backgroundColor="#fbd4d5" sx={{ maxWidth: 745}} height="10rem"
                               borderRadius="0.5rem" alignItems="center" justifyContent="center">
                            <Typography fontSize="34px" fontWeight="500" color="#210a72">
                                Pharmacy
                            </Typography>
                        </Stack>
                    </Grid>

                    <Grid item lg={6} spacing={10} >
                        <Stack direction ="column" backgroundColor="#a5d5e4" sx={{ maxWidth: 745}} height="10rem"
                               borderRadius="0.5rem" alignItems="center" justifyContent="center">
                            <Typography fontSize="34px" fontWeight="500" color="#210a72">
                                Laundry
                            </Typography>
                        </Stack>
                    </Grid>
                    <Grid item lg={6} spacing={10} >
                        <Stack direction ="column" backgroundColor="#e68244" sx={{ maxWidth: 745}} height="10rem"
                               borderRadius="0.5rem" alignItems="center" justifyContent="center">
                            <Typography fontSize="34px" fontWeight="500" color="#210a72">
                                Grocery
                            </Typography>
                        </Stack>
                    </Grid>
                </Grid>
            </Stack>
        </Container>
    );
};

export default LandingPage;