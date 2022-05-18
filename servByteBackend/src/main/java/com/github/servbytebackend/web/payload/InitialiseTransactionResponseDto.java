package com.github.servbytebackend.web.payload;


@lombok.Data
public class InitialiseTransactionResponseDto {
    private String status;
    private String message;
    private Data data;
}
