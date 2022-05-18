import React from 'react';
import {Container, Stack, Typography} from "@mui/material";
import { useNavigate } from "react-router-dom";

const Nav = () => {

    const navigate = useNavigate();
    return (
        <Container>
            <Stack direction="row" alignItems="center" marginTop="2rem" justifyContent="center" onClick={()=>navigate("/")}>
                <Typography fontSize="34px" fontWeight="700" color="#210a72">Serv</Typography>
                <Typography fontSize="34px" fontWeight="700" color="#e68244">Byte</Typography>
            </Stack>
        </Container>
    );
};

export default Nav;