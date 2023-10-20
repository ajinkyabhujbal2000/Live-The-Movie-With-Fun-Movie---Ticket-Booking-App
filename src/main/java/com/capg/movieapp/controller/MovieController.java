package com.capg.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capg.movieapp.model.Movie;
import com.capg.movieapp.service.MovieService;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
    }


    @GetMapping("/viewAll")
    public ResponseEntity<List<Movie>> viewAllMovies() {
        List<Movie> movies = movieService.viewAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/viewMovieByID/{movieId}")
    public ResponseEntity<Movie> viewMovieByID(@PathVariable String movieId) {
        Movie movie = movieService.viewMovieByID(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    
    @PutMapping("/updateDuration/{movieId}/{duration}")
    public ResponseEntity<Movie> updateDuration(
            @PathVariable String movieId,
            @PathVariable int duration
    ) {
        Movie updatedMovie = movieService.updateDuration(movieId, duration);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    
    }
    
    @GetMapping("/viewMovieByDirectorNameAndCertification/{directorName}/{certification}")
    public ResponseEntity<List<Movie>> viewMovieByDirectorAndCertification(
            @PathVariable String directorName,
            @PathVariable String certification
    ) {
        List<Movie> movies = movieService.viewMovieByDirectorNameAndCertification(directorName, certification);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    @GetMapping("/getMovieCountDirectorWise")
    public ResponseEntity<Map<String, Integer>> getMovieCountDirectorWise() {
        Map<String, Integer> movieCount = movieService.getMovieCountDirectorWise();
        return new ResponseEntity<>(movieCount, HttpStatus.OK);
    }
    
}
