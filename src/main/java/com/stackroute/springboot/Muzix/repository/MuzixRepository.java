package com.stackroute.springboot.Muzix.repository;

import com.stackroute.springboot.Muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MuzixRepository extends JpaRepository<Track,Integer> {

    @Query(value = "SELECT * FROM Track  where name = ?1", nativeQuery = true )
    List<Track> findTitleByName(String name);


}
