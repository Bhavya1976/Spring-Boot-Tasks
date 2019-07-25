package com.stackroute.springboot.Muzix.Service;

import com.stackroute.springboot.Muzix.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.Muzix.exception.TrackNotFoundException;
import com.stackroute.springboot.Muzix.model.Track;
import com.stackroute.springboot.Muzix.repository.MuzixRepository;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
      if(muzixRepository.existsById(track.getTrackId())){
        throw new TrackAlreadyExistsException("Track Already Exists");

      }
      Track saveTrack = muzixRepository.save(track);

//
//      if(saveTrack==null){
//          throw new TrackNotFoundException("")
//      }
        return saveTrack;
    }


    //method for get all the tracks
    @Override
    public List<Track> getAllTracks() {
        return muzixRepository.findAll();
    }

    //method for update a new track
    @Override
    public boolean updateTrack(Track track,int trackId) throws TrackNotFoundException{
        Optional<Track> track1= muzixRepository.findById(trackId);

        if(muzixRepository.save(track)==null){
            throw new TrackNotFoundException("Track not found");
        }
        else if(!track1.isPresent()){
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


    @Override
    public List<Track> trackByName(String name) {
        List<Track> trackList= muzixRepository.findTitleByName(name);
        return trackList;
    }

}
