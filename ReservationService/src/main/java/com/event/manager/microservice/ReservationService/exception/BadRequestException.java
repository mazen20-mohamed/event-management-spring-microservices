package com.event.manager.microservice.ReservationService.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){

    }
    public BadRequestException(String message){
        super(message);
    }
}
