package com.stackroute.springboot.muzix.service;

import com.stackroute.springboot.muzix.model.Track;
import java.util.List;
import java.util.Optional;


public interface TrackService {

    Track saveTrack(Track track);
    List<Track> getAllTracks();
    Track updateTrack(Track track);
    Track deleteTrack(int id);
    Optional<Track> findById(int id);
}
