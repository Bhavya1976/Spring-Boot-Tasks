package com.stackroute.springboot.muzix.exception;


public class TrackAlreadyExistsException extends Exception {

    public TrackAlreadyExistsException(){}

String message;
    public TrackAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }

}
