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

    TrackService trackService;

    //constructor
    @Autowired
    public TrackController (TrackService trackService){
        this.trackService = trackService;
    }

    //Zero parameterized constructor
    public TrackController(){}

    //controller for save track
    @PostMapping("/savetrack")
    public ResponseEntity<?> saveTrack ( @RequestBody Track track){
        ResponseEntity responseEntity;
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
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);

    }

    //controller for update track
    @PutMapping("/updatetrack")
    public ResponseEntity<?> updateTrack( @RequestBody Track track) {

        try {
            trackService.updateTrack(track);
            return new ResponseEntity<String>("updated successfully",HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    // controller for delete method

    @DeleteMapping("/muzix")
  public ResponseEntity<?> deleteTrack(@RequestBody int trackId) {
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrack(trackId);
            responseEntity = new ResponseEntity("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}