package com.stackroute.springboot.muzix.exception;


public class TrackNotFoundException extends Exception {

    public TrackNotFoundException(){}

    String message1;
    public TrackNotFoundException(String message){
        super(message);
        this.message1 = message1;
    }

}
