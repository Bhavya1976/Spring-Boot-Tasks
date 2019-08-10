package com.stackroute.springboot.muzix.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//this annotation is used to create a table
@Data
@Builder
@NoArgsConstructor  //it creates constructor with out any arguments
@AllArgsConstructor   //it creates constructor with arguments
@Getter  //creates getters
@Setter //creates setters
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackId;
   private String trackName;
    private String comments;

}
