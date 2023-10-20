package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capg.movieapp.dao.MovieDAO;
import com.capg.movieapp.model.Movie;
import com.capg.movieapp.service.impl.MovieServiceImpl;

class MovieServiceImplTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock
    private MovieDAO movieDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testAddMovie() {
        // Create a sample movie for testing
        Movie movie = new Movie();
        movie.setMovieId("123");
        movie.setMovieName("Movie Name");

        // Mock the behavior of movieDAO.addMovie()
        when(movieDAO.addMovie(movie)).thenReturn(movie);

        // Call the service method to add a movie
        Movie result = movieService.addMovie(movie);

        assertNotNull(result); // Check if the result is not null
        assertEquals("123", result.getMovieId()); // Check if the ID matches
        assertEquals("Movie Name", result.getMovieName()); // Check if the name matches
    }

    @Test
    void testViewAll() {
        // Create a list of sample movies for testing
        List<Movie> movies = new ArrayList<>();
        // Add some sample movies to the list

        // Mock the behavior of movieDAO.viewAll()
        when(movieDAO.viewAll()).thenReturn(movies);

        // Call the service method to get a list of movies
        List<Movie> result = movieService.viewAll();

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testViewMovieByID() {
        // Create a sample movie ID for testing
        String movieId = "123";

        // Create a sample movie for testing
        Movie movie = new Movie();
        movie.setMovieId(movieId);
        // Set other properties of the movie

        // Mock the behavior of movieDAO.viewMovieByID()
        when(movieDAO.viewMovieByID(movieId)).thenReturn(movie);

        // Call the service method to get a movie by ID
        Movie result = movieService.viewMovieByID(movieId);

        assertNotNull(result); // Check if the result is not null
        assertEquals(movieId, result.getMovieId()); // Check if the ID matches
        // Add additional assertions based on the expected behavior.
    }

//    @Test
//    void testUpdateDuration() {
//        // Create a sample movie ID for testing
//        String movieId = "123";
//
//        // Create a sample duration for testing
//        int duration = 150;
//
//        // Create a sample movie for testing
//        Movie movie = new Movie();
//        movie.setMovieId(movieId);
//        // Set other properties of the movie
//
//        // Mock the behavior of movieDAO.updateDuration()
//        when(movieDAO.updateDuration(movieId, duration)).thenReturn(movie);
//
//        // Call the service method to update the duration of a movie
//        Movie result = movieService.updateDuration(movieId, duration);
//
//        assertNotNull(result); // Check if the result is not null
//        assertEquals(movieId, result.getMovieId()); // Check if the ID matches
//        assertEquals(duration, result.getDuration()); // Check if the duration matches
//        // Add additional assertions based on the expected behavior.
//    }

    @Test
    void testViewMovieByDirectorNameAndCertification() {
        // Create sample director name and certification for testing
        String directorName = "Sample Director";
        String certification = "PG";

        // Create a list of sample movies for testing
        List<Movie> movies = new ArrayList<>();
        // Add some sample movies to the list

        // Mock the behavior of movieDAO.viewMovieByDirectorNameAndCertification()
        when(movieDAO.viewMovieByDirectorNameAndCertification(directorName, certification)).thenReturn(movies);

        // Call the service method to get a list of movies by director name and certification
        List<Movie> result = movieService.viewMovieByDirectorNameAndCertification(directorName, certification);

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testGetMovieCountDirectorWise() {
        // Create a map with sample movie counts by director for testing
        Map<String, Integer> movieCountMap = new HashMap<>();
        movieCountMap.put("Director1", 3);
        movieCountMap.put("Director2", 5);

        // Mock the behavior of movieDAO.getMovieCountDirectorWise()
        when(movieDAO.getMovieCountDirectorWise()).thenReturn(movieCountMap);

        // Call the service method to get a map of movie counts by director
        Map<String, Integer> result = movieService.getMovieCountDirectorWise();

        assertNotNull(result); // Check if the result is not null
        assertEquals(movieCountMap, result); // Check if the returned map is the same as the input
    }

   

  
    // You can write additional test cases as needed

}
