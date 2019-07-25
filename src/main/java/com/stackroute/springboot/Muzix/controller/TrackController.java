package com.stackroute.springboot.Muzix.controller;

import com.stackroute.springboot.Muzix.Service.MuzixService;
import com.stackroute.springboot.Muzix.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.Muzix.model.Track;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.EventListener;


import java.util.List;



@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    MuzixService muzixService;
    public TrackController (MuzixService muzixService){
        this.muzixService = muzixService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack (@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            muzixService.saveTrack(track);
            responseEntity = new ResponseEntity<String >("Successfully created", HttpStatus.CREATED);
        }
        catch (TrackAlreadyExistsException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }


    @GetMapping("track")
    public ResponseEntity<?> getAllTrack(@RequestBody Track track){

        //getting all tracks
        return new ResponseEntity<List<Track>>(muzixService.getAllTracks(),HttpStatus.OK);

    }

    @PutMapping("/track/{id}")
    public ResponseEntity<?> getTrack(@RequestBody Track track,@PathVariable("id") int id) {

        try {
            muzixService.updateTrack(track, id);
            return new ResponseEntity<String>("updated successfully",HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }


    }

    @DeleteMapping("/track/{id}")
    public void deleteTrack(@PathVariable int trackId) {
        muzixService.deleteTrack(trackId);
    }

    @GetMapping("/track/{name}")
    public ResponseEntity<?> trackByName(@PathVariable String name){

        return new ResponseEntity<List<Track>>(muzixService.trackByName(name),HttpStatus.OK);
    }


}


