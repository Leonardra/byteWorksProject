package com.github.servbytebackend.web.controller;

import com.github.servbytebackend.services.InitialiseTransactionService;
import com.github.servbytebackend.web.payload.InitialiseTransactionRequestDto;
import com.github.servbytebackend.web.payload.InitialiseTransactionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class InitialisePaymentController {

    @Autowired
    private InitialiseTransactionService initialiseTransactionService;


    @PostMapping(value= "/initializeTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public InitialiseTransactionResponseDto initializeTransaction(@RequestBody InitialiseTransactionRequestDto initializeTransactionRequestDTO) {
        return initialiseTransactionService.initializeTransaction(initializeTransactionRequestDTO); }
}
