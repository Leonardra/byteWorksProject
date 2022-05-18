package com.github.servbytebackend.services;

import com.github.servbytebackend.web.payload.InitialiseTransactionRequestDto;
import com.github.servbytebackend.web.payload.InitialiseTransactionResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class InitialiseTransactionServiceImpl implements InitialiseTransactionService{

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public InitialiseTransactionResponseDto initializeTransaction(InitialiseTransactionRequestDto initializeTransactionRequestDTO) {
        String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        String key = "sk_test_6df8798ba1a6d3dd4fc3e735f1a646d1501998df";
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + key);
        HttpEntity<InitialiseTransactionRequestDto> entity = new HttpEntity<InitialiseTransactionRequestDto>(initializeTransactionRequestDTO, headers);
        ResponseEntity<InitialiseTransactionResponseDto> response = restTemplate.postForEntity(url, entity, InitialiseTransactionResponseDto.class);
        return response.getBody();
    }


}
