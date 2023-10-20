package com.capg.movieapp.model;

import jakarta.persistence.*;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="theatre")
public class Theatre {

    @Id
    @Column(name = "theatre_id")
    @NotBlank(message = "Provide value for theatre id")
    private String theatreId;

    @Column(name = "theatre_name")
    @NotBlank(message = "Provide value for theatre name")
    private String theatreName;
    
    @Column(name = "city")
    @NotBlank(message = "Provide value for city")
    private String city;

    @Column(name = "capacity_of_each_screen")
    @Min(value = 100, message = "capacityOfEachScreen should be at least 100 ")
    @Max(value = 300, message = "capacityOfEachScreen should be at most 300 ")
    private int capacityOfEachScreen;

    @Column(name = "total_screens")
    @Min(value = 1, message = "total_screens should be at least 1 ")
    @Max(value = 10, message = "total_screens should be at most 10 ")
    private int totalScreens;

    @Column(name = "ticket_cost")
    @Min(value = 250, message = "ticket_cost should be at least 250 ")
    @Max(value = 2500, message = "ticket_cost should be at most 2500 ")
    private String ticketCost;



    public Theatre() {
        // Default constructor
    }

    public Theatre(String theatreId, String theatreName, String city, int capacityOfEachScreen,
                   int totalScreens, String ticketCost) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
        this.capacityOfEachScreen = capacityOfEachScreen;
        this.totalScreens = totalScreens;
        this.ticketCost = ticketCost;
    }

    // Getters and setters

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacityOfEachScreen() {
        return capacityOfEachScreen;
    }

    public void setCapacityOfEachScreen(int capacityOfEachScreen) {
        this.capacityOfEachScreen = capacityOfEachScreen;
    }

    public int getTotalScreens() {
        return totalScreens;
    }

    public void setTotalScreens(int totalScreens) {
        this.totalScreens = totalScreens;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }


}
