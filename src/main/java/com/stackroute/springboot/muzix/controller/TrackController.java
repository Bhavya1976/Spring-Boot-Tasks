package com.stackroute.springboot.muzix.controller;

import com.stackroute.springboot.muzix.service.TrackService;
import com.stackroute.springboot.muzix.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

   private  TrackService trackService;

    //constructor
    @Autowired
    public TrackController (TrackService trackService){
        this.trackService = trackService;
    }

    //Zero parameterized constructor
    public TrackController(){}


    ResponseEntity responseEntity;
    //controller for save track
    @PostMapping("/savetrack")
    public ResponseEntity<?> saveTrack ( @RequestBody Track track){

        try{
                trackService.saveTrack(track);
                responseEntity = new ResponseEntity<String >("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception ex){
              responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
        return  responseEntity;
    }

    //controller for the get track

    @GetMapping("/gettrack")
    public ResponseEntity<?> getAllTracks(){
        //getting all tracks
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    //controller for update track
    @PutMapping("/updatetrack")
    public ResponseEntity<?> updateTrack( @RequestBody Track track) {

        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("updated successfully",HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }

    // controller for delete method

    @DeleteMapping("/deletetrack")
    public ResponseEntity<?> deleteTrack(@RequestBody int trackId) {
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrack(trackId);
            responseEntity = new ResponseEntity("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }
}