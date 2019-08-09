package com.stackroute.springboot.muzix.service;

import com.stackroute.springboot.muzix.model.Track;
import com.stackroute.springboot.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

   private TrackRepository trackRepository;

    @Autowired
    //Constructor for MuzixServiceImpl
    public TrackServiceImpl(TrackRepository trackRepository){

        this.trackRepository = trackRepository;
    }

    //method for save the track
    @Override
    public Track saveTrack(Track track) {

        Track saveTrack = trackRepository.save(track);
        return saveTrack;
    }

    //method for get all the tracks
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    //method for update a new track
    @Override
    public Track updateTrack(Track track){

     /*  Integer  id = track.getTrackId();
        Optional<Track> userOptional = trackRepository.findById(id);*/
        trackRepository.save(track);
        return track;

    }
    @Override
    public Track deleteTrack(Track track) {

        trackRepository.deleteById(track.getTrackId());
        return track;
    }
    @Override
    public Optional<Track> findById(int id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> trackByName(String name) {
        List<Track> tracks=trackRepository.findTitleByName(name);
        return tracks;
    }
}
