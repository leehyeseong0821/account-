package com.cloths.projectteam5.exception;

public class CustomInternalServerErrorException extends RuntimeException {
    public CustomInternalServerErrorException(String message){
        super(message);
    }
}
