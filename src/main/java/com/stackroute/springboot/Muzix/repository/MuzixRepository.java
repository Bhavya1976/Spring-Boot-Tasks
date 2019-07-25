package com.stackroute.springboot.Muzix.repository;

import com.stackroute.springboot.Muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuzixRepository extends JpaRepository<Track,Integer> {

}
