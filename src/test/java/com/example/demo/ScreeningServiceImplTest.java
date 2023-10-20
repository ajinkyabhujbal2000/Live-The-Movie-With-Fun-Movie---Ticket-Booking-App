package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capg.movieapp.dao.ScreeningDAO;
import com.capg.movieapp.model.Screening;
import com.capg.movieapp.service.impl.ScreeningServiceImpl;

class ScreeningServiceImplTest {

    @InjectMocks
    private ScreeningServiceImpl screeningService;

    @Mock
    private ScreeningDAO screeningDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

//    @Test
//    void testAddScreening() {
//        // Create a sample screening for testing
//        Screening screening = new Screening();
//        screening.setScreeningId("123");
//        screening.setScreeningId(LocalDate.now());
//
//        // Create sample movie and theatre IDs for testing
//        String movieId = "movie123";
//        String theatreId = "theatre123";
//
//        // Mock the behavior of screeningDAO.addScreening()
//        when(screeningDAO.addScreening(screening, movieId, theatreId)).thenReturn(screening);
//
//        // Call the service method to add a screening
//        Screening result = screeningService.addScreening(screening, movieId, theatreId);
//
//        assertNotNull(result); // Check if the result is not null
//        assertEquals("123", result.getScreeningId()); // Check if the ID matches
//        assertEquals(LocalDate.now(), result.getScreeningDate()); // Check if the date matches
//    }

//    @Test
//    void testUpdateToDate() {
//        // Create a sample screening ID for testing
//        String screeningId = "123";
//
//        // Create a sample date for testing
//        LocalDate toDate = LocalDate.now().plusDays(7);
//
//        // Create a sample screening for testing
//        Screening screening = new Screening();
//        screening.setScreeningId(screeningId);
//        // Set other properties of the screening
//
//        // Mock the behavior of screeningDAO.updateToDate()
//        when(screeningDAO.updateToDate(screeningId, toDate)).thenReturn(screening);
//
//        // Call the service method to update the toDate of a screening
//        Screening result = screeningService.updateToDate(screeningId, toDate);
//
//        assertNotNull(result); // Check if the result is not null
//        assertEquals(screeningId, result.getScreeningId()); // Check if the ID matches
//        assertEquals(toDate, result.getToDate()); // Check if the toDate matches
//        // Add additional assertions based on the expected behavior.
//    }

    @Test
    void testViewAll() {
        // Create a list of sample screenings for testing
        List<Screening> screenings = new ArrayList<>();
        // Add some sample screenings to the list

        // Mock the behavior of screeningDAO.viewAll()
        when(screeningDAO.viewAll()).thenReturn(screenings);

        // Call the service method to get a list of screenings
        List<Screening> result = screeningService.viewAll();

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testViewByScreenID() {
        // Create a sample screening ID for testing
        String screeningId = "123";

        // Create a sample screening for testing
        Screening screening = new Screening();
        screening.setScreeningId(screeningId);
        // Set other properties of the screening

        // Mock the behavior of screeningDAO.viewByScreenID()
        when(screeningDAO.viewByScreenID(screeningId)).thenReturn(screening);

        // Call the service method to get a screening by ID
        Screening result = screeningService.viewByScreenID(screeningId);

        assertNotNull(result); // Check if the result is not null
        assertEquals(screeningId, result.getScreeningId()); // Check if the ID matches
        // Add additional assertions based on the expected behavior.
    }

 

    @Test
    void testViewScreeningByMovieNameAndCity() {
        // Create sample movie name and city for testing
        String movieName = "MovieName";
        String city = "CityName";

        // Create a list of sample screenings for testing
        List<Screening> screenings = new ArrayList<>();
        // Add some sample screenings to the list

        // Mock the behavior of screeningDAO.viewScreeningByMovieNameAndCity()
        when(screeningDAO.viewScreeningByMovieNameAndCity(movieName, city)).thenReturn(screenings);

        // Call the service method to get a list of screenings by movie name and city
        List<Screening> result = screeningService.viewScreeningByMovieNameAndCity(movieName, city);

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testViewScreeningByTheatreName() {
        // Create a sample theatre name for testing
        String theatreName = "TheatreName";

        // Create a list of sample screenings for testing
        List<Screening> screenings = new ArrayList<>();
        // Add some sample screenings to the list

        // Mock the behavior of screeningDAO.viewScreeningByTheatreName()
        when(screeningDAO.viewScreeningByTheatreName(theatreName)).thenReturn(screenings);

        // Call the service method to get a list of screenings by theatre name
        List<Screening> result = screeningService.viewScreeningByTheatreName(theatreName);

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }
}
