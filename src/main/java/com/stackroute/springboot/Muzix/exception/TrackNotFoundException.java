package com.stackroute.springboot.Muzix.exception;

public class TrackNotFoundException extends Exception{

    public TrackNotFoundException (){}


    public TrackNotFoundException(String msg){

      super(msg);

    }

}
