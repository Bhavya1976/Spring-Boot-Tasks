package com.stackroute.springboot.muzix.controller;

import com.stackroute.springboot.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.muzix.exception.TrackNotFoundException;
import com.stackroute.springboot.muzix.service.TrackService;
import com.stackroute.springboot.muzix.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
@PropertySource("classpath:application.properties")
public class TrackController {

   private  TrackService trackService;

    @Value("${exceptionMsg}")
    String message;



    //constructor
    @Autowired
    public TrackController (TrackService trackService){
        this.trackService = trackService;
    }

    //Zero parameterized constructor
    public TrackController(){}


    private ResponseEntity responseEntity;
    //controller for save track
    @PostMapping("/savetrack")
    public ResponseEntity<?> saveTrack ( @RequestBody Track track){

        try{
                Track savedTrack = trackService.saveTrack(track);

                responseEntity = new ResponseEntity(track, HttpStatus.CREATED);
        }
        catch (TrackAlreadyExistsException ex){
              responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }catch(Exception ex){

            responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
        return  responseEntity;//returns the saved track and httpStatus code
    }

    //controller for the get track

    @GetMapping("/gettrack")
    public ResponseEntity<?> getAllTracks(){
        //getting all tracks
        try {
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);//returns the tracks and httpStatus as OK
        } catch (TrackNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //controller for update track
    @PutMapping("/updatetrack")
    public ResponseEntity<?> updateTrack( @RequestBody Track track) {

        try {
            Track updatedTrack = trackService.updateTrack(track);
            responseEntity = new ResponseEntity(updatedTrack,HttpStatus.OK);
        }
        catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;//returns the both updated track and httpStatus
    }

    // controller for delete method

    @DeleteMapping("/deletetrack")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track) {

        try {

            Track deletedTrack = trackService.deleteTrack(track);

            responseEntity = new ResponseEntity(deletedTrack, HttpStatus.OK);
        } catch (TrackNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;// returns the both deleted track and httpStatus
    }
}