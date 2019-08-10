package com.stackroute.springboot.muzix.service;

import com.stackroute.springboot.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.muzix.exception.TrackNotFoundException;
import com.stackroute.springboot.muzix.model.Track;
import com.stackroute.springboot.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
   private TrackRepository trackRepository;

    @Autowired
    //Constructor for MuzixServiceImpl
    public TrackServiceImpl(TrackRepository trackRepository){

        this.trackRepository = trackRepository;
    }

    //method for save the track
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        Track saveTrack = null;

        if(trackRepository.existsById(track.getTrackId()))
            throw new TrackAlreadyExistsException("Track Already exists");
        else {
            saveTrack = trackRepository.save(track);
        }


        return saveTrack;
    }

    //method for get all the tracks
    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        return trackRepository.findAll();
    }

    //method for update a new track
    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException{

        if(!trackRepository.existsById(track.getTrackId())) {
            throw new TrackNotFoundException("Track Not Found Exception");
        }
        else {
            trackRepository.save(track);
        }
        return track;

    }
    @Override
    public Track deleteTrack(Track track) throws TrackNotFoundException{
        if(!trackRepository.existsById(track.getTrackId())) {
            throw new TrackNotFoundException("Track Not Found Exception");
        }
        else{
            trackRepository.deleteById(track.getTrackId());
        }
        return track;
    }
    @Override
    public Optional<Track> findById(int id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> trackByName(String name){
        List<Track> tracks=trackRepository.findTitleByName(name);
        return tracks;
    }
}
