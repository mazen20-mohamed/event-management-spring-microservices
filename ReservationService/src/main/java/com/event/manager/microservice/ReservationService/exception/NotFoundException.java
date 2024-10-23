package com.event.manager.microservice.ReservationService.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){

    }
    public NotFoundException(String message){
        super(message);
    }
}
