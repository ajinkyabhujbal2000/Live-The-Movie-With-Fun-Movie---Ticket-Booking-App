package com.capg.movieapp.dao.impl;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.movieapp.dao.MovieDAO;
import com.capg.movieapp.exception.InvalidEntityException;
//import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Movie;
import com.capg.movieapp.repository.MovieRepository;
//import com.mysql.cj.Query;

import jakarta.persistence.*;
import java.util.*;


@Repository
public class MovieDAOImpl implements MovieDAO {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieDAOImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
    	Movie addedMovie = movieRepository.save(movie);
//    	log.info("Movie with id {} added successfully", addedMovie.getMovieId());
        return addedMovie;
    }

    @Override
    public List<Movie> viewAll() {
        
        return movieRepository.findAll();
    }
    
    @Override
    public Movie viewMovieByID(String movieId) throws InvalidEntityException {
        // logic to retrieve a movie by its ID from the database
    	Optional<Movie> movieById = movieRepository.findById(movieId);
    	if (movieById.isPresent()) {
    		return movieById.get();
    	}
    	else {
    		throw new InvalidEntityException("Movie Id "+movieId+" does not exist");
    	}
    }

    @Override
    public Movie updateDuration(String movieId, int duration) {
        // Find the movie by ID
        Movie existingMovie = movieRepository.findById(movieId)
                .orElseThrow();

        // Update the duration
        existingMovie.setDuration(duration);

        // Save and return the updated movie
        return movieRepository.save(existingMovie);
    }
    
	@Override
    public List<Movie> viewMovieByDirectorNameAndCertification(String directorName, String certification) {
        // logic to retrieve movies by director name and certification from the database
        return movieRepository.findByDirectorNameAndCertification(directorName, certification);
    }


	
    @Override
    public Map<String, Integer> getMovieCountDirectorWise() {
 
        List<Object[]> resultList = movieRepository.findByCountDirectorwise();

        Map<String, Integer> directorMovieCounts = new HashMap<>();
        for (Object[] result : resultList) {
            String directorName = (String) result[0];
            Long movieCount = (Long) result[1];
            directorMovieCounts.put(directorName, movieCount.intValue());
        }
        return directorMovieCounts;
    }


}
