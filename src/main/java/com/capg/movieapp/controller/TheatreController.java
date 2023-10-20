package com.capg.movieapp.controller;


import com.capg.movieapp.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 


 

import java.util.List;


import com.capg.movieapp.model.Theatre;
import com.capg.movieapp.service.TheatreService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/theatre")
public class TheatreController {

    private final TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/addTheatre")
    public ResponseEntity<?> addTheatre(@RequestBody Theatre theatre) {
        Theatre addedTheatre = theatreService.addTheatre(theatre);
       // return ResponseEntity.ok(addedTheatre);
        return new ResponseEntity<>(addedTheatre, HttpStatus.CREATED);

    }

    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllTheatres() {
        List<Theatre> theatres = theatreService.viewAll();
       // return ResponseEntity.ok(theatres);
        return new ResponseEntity<>(theatres, HttpStatus.OK);

    }
    
    @PutMapping("/updateTicketCost/{theatreId}/{ticketCost}")
    public ResponseEntity<?> updateTicketCost(
            @PathVariable(name = "theatreId") String theatreId,
            @PathVariable(name = "ticketCost") String ticketCost
    ) {
        Theatre updatedTheatre = theatreService.updateTicketCost(theatreId, ticketCost);
        return ResponseEntity.ok(updatedTheatre);
    }
    
    @GetMapping("/viewTheatreById/{theatreId}")
    public ResponseEntity<?> viewTheatreById(@PathVariable("theatreId") String theatreId) {
        Theatre theatre = theatreService.viewTheatreByID(theatreId);
        return ResponseEntity.ok(theatre);
    }

	  @GetMapping("/viewTheatresByCityAndTicketCost/{city}/{ticketCost}")
	  public ResponseEntity<?> viewTheatresByCityAndTicketCost(
	          @PathVariable(name = "city") String city,
	          @PathVariable(name = "ticketCost") String ticketCost
	  ) {
	      List<Theatre> theatres = theatreService.viewTheatreByCityAndTicketCost(city, ticketCost);
	      return ResponseEntity.ok(theatres);
	  }
	  
	  

    


    

}
