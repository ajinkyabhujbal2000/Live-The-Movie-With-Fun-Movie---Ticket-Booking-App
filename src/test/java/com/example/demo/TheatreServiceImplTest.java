package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capg.movieapp.dao.TheatreDAO;
import com.capg.movieapp.model.Theatre;
import com.capg.movieapp.service.impl.TheatreServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TheatreServiceImplTest {

    @InjectMocks
    private TheatreServiceImpl theatreService;

    @Mock
    private TheatreDAO theatreDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddTheatre() {
        Theatre theatre = new Theatre(); // Create a Theatre object

        // Mock the behavior of theatreDAO.addTheatre()
        Mockito.when(theatreDAO.addTheatre(theatre)).thenReturn(theatre);

        Theatre result = theatreService.addTheatre(theatre);

        assertNotNull(result); // Check if the result is not null
        assertEquals(theatre, result); // Check if the returned object is the same as the input
    }

    @Test
    void testViewAll() {
        List<Theatre> theatreList = new ArrayList<>(); // Create a list of Theatre objects

        // Mock the behavior of theatreDAO.viewAll()
        Mockito.when(theatreDAO.viewAll()).thenReturn(theatreList);

        List<Theatre> result = theatreService.viewAll();

        assertNotNull(result); // Check if the result is not null
        assertEquals(theatreList, result); // Check if the returned list is the same as the input
    }

    @Test
    void testUpdateTicketCost() {
        String theatreId = "theatre123";
        double ticketCost = 50.0;

        Theatre updatedTheatre = new Theatre(); // Create an updated Theatre object

        // Mock the behavior of theatreDAO.updateTicketCost()
        Mockito.when(theatreDAO.updateTicketCost(theatreId, ticketCost)).thenReturn(updatedTheatre);

        Theatre result = theatreService.updateTicketCost(theatreId, ticketCost);

        assertNotNull(result); // Check if the result is not null
        assertEquals(updatedTheatre, result); // Check if the returned object is the same as the updated one
    }

    @Test
    void testViewTheatreByID() {
        String theatreId = "theatre123";
        Theatre theatre = new Theatre(); // Create a Theatre object

        // Mock the behavior of theatreDAO.viewTheatreByID()
        Mockito.when(theatreDAO.viewTheatreByID(theatreId)).thenReturn(theatre);

        Theatre result = theatreService.viewTheatreByID(theatreId);

        assertNotNull(result); // Check if the result is not null
        assertEquals(theatre, result); // Check if the returned object is the same as the input
    }

    @Test
    void testViewTheatreByCityAndTicketCost() {
        String city = "SampleCity";
        double ticketCost = 50.0;

        List<Theatre> theatreList = new ArrayList<>(); // Create a list of Theatre objects

        // Mock the behavior of theatreDAO.viewTheatreByCityAndTicketCost()
        Mockito.when(theatreDAO.viewTheatreByCityAndTicketCost(city, ticketCost)).thenReturn(theatreList);

        List<Theatre> result = theatreService.viewTheatreByCityAndTicketCost(city, ticketCost);

        assertNotNull(result); // Check if the result is not null
        assertEquals(theatreList, result); // Check if the returned list is the same as the input
    }
}
