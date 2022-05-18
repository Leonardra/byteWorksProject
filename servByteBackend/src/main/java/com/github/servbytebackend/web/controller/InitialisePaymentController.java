package com.github.servbytebackend.web.controller;

import com.github.servbytebackend.services.InitialiseTransactionService;
import com.github.servbytebackend.web.payload.InitialiseTransactionRequestDto;
import com.github.servbytebackend.web.payload.InitialiseTransactionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InitialisePayment {

    @Autowired
    private InitialiseTransactionService initialiseTransactionService;


    @RequestMapping(path = "/initializetransaction", method = RequestMethod.POST)
    public InitialiseTransactionResponseDto initializeTransaction(@RequestBody InitialiseTransactionRequestDto initializeTransactionRequestDTO) {
        return initialiseTransactionService.initializeTransaction(initializeTransactionRequestDTO); }
}
