package com.stackroute.springboot.muzix.service;

import com.stackroute.springboot.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.muzix.exception.TrackNotFoundException;
import com.stackroute.springboot.muzix.model.Track;
import java.util.List;
import java.util.Optional;


public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExistsException;
    List<Track> getAllTracks() throws TrackNotFoundException;
    Track updateTrack(Track track) throws TrackNotFoundException;
    Track deleteTrack(Track track) throws TrackNotFoundException;
    Optional<Track> findById(int id)throws TrackNotFoundException;
    public List<Track> trackByName(String name)throws TrackNotFoundException;
}
