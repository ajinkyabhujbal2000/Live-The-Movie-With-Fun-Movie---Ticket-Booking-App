package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capg.movieapp.dao.BookMovieDAO;
import com.capg.movieapp.model.Booking;
import com.capg.movieapp.service.impl.BookMovieServiceImpl;

class BookMovieServiceImplTest {

    @InjectMocks
    private BookMovieServiceImpl bookMovieService;

    @Mock
    private BookMovieDAO bookMovieDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testAddBooking() {
        // Create a sample booking for testing
        Booking booking = new Booking();
        booking.setBookingId("123");
        booking.setBookingDate(LocalDate.now());

        // Mock the behavior of bookMovieDAO.addBooking()
        when(bookMovieDAO.addBooking(booking)).thenReturn(booking);

        // Call the service method to add a booking
        Booking result = bookMovieService.addBooking(booking);

        assertNotNull(result); // Check if the result is not null
        assertEquals("123", result.getBookingId()); // Check if the ID matches
        assertEquals(LocalDate.now(), result.getBookingDate()); // Check if the date matches
    }

    @Test
    void testDeleteBooking() {
        // Create a sample booking ID for testing
        String bookingId = "123";

        // Create a sample booking for testing
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        // Set other properties of the booking

        // Mock the behavior of bookMovieDAO.deleteBooking()
        when(bookMovieDAO.deleteBooking(bookingId)).thenReturn(booking);

        // Call the service method to delete a booking
        Booking result = bookMovieService.deleteBooking(bookingId);

        assertNotNull(result); // Check if the result is not null
        assertEquals(bookingId, result.getBookingId()); // Check if the ID matches
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testViewAll() {
        // Create a list of sample bookings for testing
        List<Booking> bookings = new ArrayList<>();
        // Add some sample bookings to the list

        // Mock the behavior of bookMovieDAO.viewAll()
        when(bookMovieDAO.viewAll()).thenReturn(bookings);

        // Call the service method to get a list of bookings
        List<Booking> result = bookMovieService.viewAll();

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testViewBookingById() {
        // Create a sample booking ID for testing
        String bookingId = "123";

        // Create a sample booking for testing
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        // Set other properties of the booking

        // Mock the behavior of bookMovieDAO.viewBookingById()
        when(bookMovieDAO.viewBookingById(bookingId)).thenReturn(Optional.of(booking));

        // Call the service method to get a booking by ID
        Optional<Booking> result = bookMovieService.viewBookingById(bookingId);

        assertTrue(result.isPresent()); // Check if the result is present
        assertEquals(bookingId, result.get().getBookingId()); // Check if the ID matches
        // Add additional assertions based on the expected behavior.
    }

    @Test
    void testViewBookingByBookingDate() {
        // Create a sample booking date for testing
        LocalDate bookingDate = LocalDate.now();

        // Create a list of sample bookings for testing
        List<Booking> bookings = new ArrayList<>();
        // Add some sample bookings to the list

        // Mock the behavior of bookMovieDAO.viewBookingByBookingDate()
        when(bookMovieDAO.viewBookingByBookingDate(bookingDate)).thenReturn(bookings);

        // Call the service method to get a list of bookings by date
        List<Booking> result = bookMovieService.viewBookingByBookingDate(bookingDate);

        assertNotNull(result); // Check if the result is not null
        // Add additional assertions based on the expected behavior.
    }


}
