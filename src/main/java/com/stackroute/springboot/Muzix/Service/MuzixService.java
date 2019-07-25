package com.stackroute.springboot.Muzix.Service;

import org.springframework.web.bind.annotation.PathVariable;

import com.stackroute.springboot.Muzix.model.Track;
import java.util.List;

public interface MuzixService {


    public Track saveTrack(Track track);

    public List<Track> getAllTracks();

    public boolean updateTrack(Track track, int trackId);

    public void deleteTrack(@PathVariable("id") int trackId);

    public List<Track> trackByName(String name);
}