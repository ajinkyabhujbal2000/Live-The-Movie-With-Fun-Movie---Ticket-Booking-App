package com.capg.movieapp.controller;

 

import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Screening;
import com.capg.movieapp.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

 

@RestController
@RequestMapping("/screen")
public class ScreeningController {

	 @Autowired
    private final ScreeningService screeningService;

 

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

 


 

    @PostMapping("/addScreening/{movieId}/{theatreId}")
    public ResponseEntity<Screening> addScreening(   
            @PathVariable(name = "movieId") String movieId,
            @PathVariable(name = "theatreId") String theatreId,
            @RequestBody Screening screening
    ) {
        try {
            Screening addedScreening = screeningService.addScreening(screening, movieId, theatreId);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedScreening);
        } catch (InvalidEntityException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/updateToDate/{screeningId}/{toDate}")
    public ResponseEntity<String> updateToDate(
            @PathVariable String screeningId,
            @PathVariable LocalDate toDate
    ) {
        try {
            screeningService.updateToDate(screeningId, toDate);
            return ResponseEntity.status(HttpStatus.OK).body("Screening toDate updated successfully");
        } catch (InvalidEntityException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

 

    @GetMapping("/viewAll")
    public ResponseEntity<List<Screening>> viewAllScreenings() {
        List<Screening> screenings = screeningService.viewAll();
        return ResponseEntity.ok(screenings);
    }

 

    @GetMapping("/viewByScreenId/{screeningId}")
    public ResponseEntity<Screening> viewScreeningById(@PathVariable String screeningId) {
        try {
            Screening screening = screeningService.viewByScreenID(screeningId);
            return ResponseEntity.ok(screening);
        } catch (InvalidEntityException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

   
    
}