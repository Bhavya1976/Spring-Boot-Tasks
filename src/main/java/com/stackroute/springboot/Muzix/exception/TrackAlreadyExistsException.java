package com.stackroute.springboot.Muzix.exception;

public class TrackAlreadyExistsException extends Exception {

    public TrackAlreadyExistsException(){}


    public TrackAlreadyExistsException(String message){
        super(message);
        //this.message = message;
    }

}
