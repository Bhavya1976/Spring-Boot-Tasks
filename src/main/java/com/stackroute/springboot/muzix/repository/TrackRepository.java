package com.stackroute.springboot.muzix.repository;

import com.stackroute.springboot.muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
   
}
