package com.stackroute.springboot.muzix.repository;

import com.stackroute.springboot.muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    @Query(value = "select * from Track where trackName=?1",nativeQuery = true)
    List<Track> findTitleByName(String name);
}
