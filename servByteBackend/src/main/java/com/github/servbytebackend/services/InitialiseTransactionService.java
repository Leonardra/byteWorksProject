package com.github.servbytebackend.services;

import com.github.servbytebackend.web.payload.InitialiseTransactionRequestDto;
import com.github.servbytebackend.web.payload.InitialiseTransactionResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface InitialiseTransactionService {

    InitialiseTransactionResponseDto initializeTransaction (InitialiseTransactionRequestDto initializeTransactionRequestDTO);
}
