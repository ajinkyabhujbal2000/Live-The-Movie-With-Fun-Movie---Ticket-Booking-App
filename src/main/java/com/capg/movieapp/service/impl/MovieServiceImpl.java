package com.capg.movieapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.movieapp.dao.MovieDAO;
import com.capg.movieapp.model.Movie;
import com.capg.movieapp.service.MovieService;

import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDAO movieDAO;

    @Autowired
    public MovieServiceImpl(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    public Movie addMovie(Movie movie) {
        
        return movieDAO.addMovie(movie);
    }


    @Override
    public List<Movie> viewAll() {
    	
        return movieDAO.viewAll();
    }
    
    @Override
    public Movie viewMovieByID(String movieId) {
        
        return movieDAO.viewMovieByID(movieId);
    }
    
    @Override
    public Movie updateDuration(String movieId, int duration) {
        
        return movieDAO.updateDuration(movieId, duration);
    }
    
    @Override
    public List<Movie> viewMovieByDirectorNameAndCertification(String directorName, String certification) {
        
        return movieDAO.viewMovieByDirectorNameAndCertification(directorName, certification);
    }
    
    @Override
    public Map<String, Integer> getMovieCountDirectorWise() {
        
        return movieDAO.getMovieCountDirectorWise();
    }
    
}



