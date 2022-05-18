package com.github.servbytebackend.exceptions;

public class MealNotExistException extends RuntimeException {
    public MealNotExistException(String message) {
        super(message);
    }
}
