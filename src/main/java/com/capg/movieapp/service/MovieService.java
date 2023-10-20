package com.capg.movieapp.service;
import java.util.List;
import java.util.Map;

import com.capg.movieapp.model.Movie;

public interface MovieService {
	
    Movie addMovie(Movie movie);
    
    List<Movie> viewAll();
    
    Movie viewMovieByID(String movieId);
    
    Movie updateDuration(String movieId, int duration);
    
    List<Movie> viewMovieByDirectorNameAndCertification(String directorName, String certification);
    
    Map<String, Integer> getMovieCountDirectorWise();

}
