package com.stackroute.springboot.Muzix.Service;

import com.stackroute.springboot.Muzix.model.Track;
import com.stackroute.springboot.Muzix.repository.MuzixRepository;
import com.stackroute.springboot.Muzix.Service.MuzixService;
import com.stackroute.springboot.Muzix.model.Track;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class MuzixServiceImpl implements MuzixService {

    MuzixRepository muzixRepository;

    @Autowired
    //Constructor for MuzixServiceImpl
    public MuzixServiceImpl(MuzixRepository muzixRepository){

        this.muzixRepository = muzixRepository;
    }

    //method for save the track
    @Override
    public Track saveTrack(Track track) {

        Track saveTrack = muzixRepository.save(track);
        return saveTrack;


    }


    //method for get all the tracks
    @Override
    public List<Track> getAllTracks() {
        return muzixRepository.findAll();
    }

    //method for update a new track
    @Override
    public boolean updateTrack(Track track,int trackId){
        Optional<Track> track1= muzixRepository.findById(trackId);
        if(!track1.isPresent()){
            return false;
        }
        track.setTrackId(trackId);
        muzixRepository.save(track);
        return true;

    }
    @Override
    public void deleteTrack(@PathVariable("id") int trackId){

        muzixRepository.deleteById(trackId);
//        return deleteTrack(trackId);
    }
}
