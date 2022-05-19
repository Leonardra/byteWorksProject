import React from 'react';
import {Button, Grid, Stack, TextField, Typography} from "@mui/material";
import { useFormik } from 'formik';
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";

const PaymentPage = () => {


    const navigate = useNavigate();
    const {mealPrice} = useParams()
    const formik = useFormik({
        initialValues: {
            email: '',
        },
        onSubmit: (values) => {
            handlePayment()
        },
    });


    const handlePayment = () => {
        axios.post("http://localhost:8081/api/v1/initializeTransaction",
            {
                "email":formik.values.email,
                "amount": ""+mealPrice,
            }).then(
                res => {
                    console.log(res.data.data.authorization_url);
                    navigate(res.data.data.authorization_url);
            })
    }
    return (
        <Grid container justifyContent="center" direction="column" alignItems="center">
            <Typography>Make Payment</Typography>
            <form onSubmit={formik.handleSubmit}>
                    <Grid item lg={12} marginTop={5}>
                        <TextField
                            fullWidth
                            id="outlined-basic" variant="outlined"
                            id="email"
                            name="email"
                            label="Email"
                            type="email"
                            placeholder='enter email'
                            value={formik.values.email}
                            onChange={formik.handleChange}
                            error={formik.touched.email && Boolean(formik.errors.email)}
                            helperText={formik.touched.email && formik.errors.email}
                        />
                    </Grid>
                    <Grid item lg={12} marginTop={5}>
                        <Button variant="contained" fullWidth type="submit" sx={{ background: "#000", height: 60 }}
                        >
                            Proceed To Paystack
                        </Button>
                    </Grid>
            </form>
        </Grid>
    );
};

export default PaymentPage;