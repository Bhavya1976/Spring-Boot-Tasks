package com.stackroute.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Track")
@Data
@NoArgsConstructor

@Builder
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {

    //variables declaration
    @Id
    private int trackId;
    private String trackName;
    private String comments;
    private String rating;

    // constructor for the Track class

    public Track(int trackId, String trackName, String comments, String rating) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comments = comments;
        this.rating = rating;
    }



}
