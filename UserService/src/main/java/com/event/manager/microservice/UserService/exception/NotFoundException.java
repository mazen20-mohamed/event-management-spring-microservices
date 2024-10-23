package com.event.manager.microservice.UserService.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){

    }
    public NotFoundException(String message){
        super(message);
    }
}
