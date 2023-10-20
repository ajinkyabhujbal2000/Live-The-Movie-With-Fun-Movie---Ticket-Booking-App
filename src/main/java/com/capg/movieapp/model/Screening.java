package com.capg.movieapp.model;

 

//import javax.persistence.*;
import java.time.LocalDate;

 

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

 

@Entity
public class Screening {

 

    @Id
    @Column(name = "screening_id")
    @NotBlank(message = "Provide value for screening_id")
    private String screeningId;

 

    @Column(name = "screen_number")
    @Min(value = 1, message = "screen_number should be at least 1 ")
    @Max(value = 10, message = "screen_number should be at most 10 ")
    private int screenNumber;

 

    @Column(name = "from_date")
    @NotNull
    @NotBlank(message = "Provide value for from_date")
    private LocalDate fromDate;

 

    @Column(name = "to_date")
    @NotBlank(message = "Provide value for to_date")
    private LocalDate toDate;

 

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movieObj;

 

    @ManyToOne
    @JoinColumn(name = "theatreid")
    private Theatre theatreObj;

 

    // Constructors, getters, and setters

 

    public Screening() {
        // Default constructor
    }

 

    public Screening(String screeningId, int screenNumber, LocalDate fromDate, LocalDate toDate, Movie movieObj, Theatre theatreObj) {
        this.screeningId = screeningId;
        this.screenNumber = screenNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.movieObj = movieObj;
        this.theatreObj = theatreObj;
    }

 

    // Getter and Setter methods for all attributes

 

    public String getScreeningId() {
        return screeningId;
    }

 

    public void setScreeningId(String screeningId) {
        this.screeningId = screeningId;
    }

 

    public int getScreenNumber() {
        return screenNumber;
    }

 

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

 

    public LocalDate getFromDate() {
        return fromDate;
    }

 

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

 

    public LocalDate getToDate() {
        return toDate;
    }

 

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

 

    public Movie getMovieObj() {
        return movieObj;
    }

 

    public void setMovieObj(Movie movieObj) {
        this.movieObj = movieObj;
    }

 

    public Theatre getTheatreObj() {
        return theatreObj;
    }

 

    public void setTheatreObj(Theatre theatreObj) {
        this.theatreObj = theatreObj;
    }

 

    // toString() method for debugging and logging

 

    @Override
    public String toString() {
        return "Screening{" +
                "screeningId='" + screeningId + '\'' +
                ", screenNumber=" + screenNumber +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", movieObj=" + movieObj +
                ", theatreObj=" + theatreObj +
                '}';
    }
}