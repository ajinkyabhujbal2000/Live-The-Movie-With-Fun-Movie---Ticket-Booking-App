package com.capg.movieapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Booking;
import com.capg.movieapp.service.BookMovieService;

@RestController
@RequestMapping("/bookMovie")
public class BookMovieController {
	final BookMovieService bookMovieService;

	@Autowired
	public BookMovieController(BookMovieService bookMovieService) {
		this.bookMovieService = bookMovieService;
	}

	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		Booking addedBooking = bookMovieService.addBooking(booking);
		if (addedBooking != null) {
			return ResponseEntity.ok(addedBooking);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/updateTicketCost/{bookingId}/{amount}")
    public ResponseEntity<?> updateBookingCost(
            @PathVariable(name = "bookingId") String bookingId,
            @PathVariable(name = "amount") double amount
    ) {
        Booking upateBooking = bookMovieService.updateBookingCost(bookingId, amount);
        return ResponseEntity.ok(upateBooking);
    }

	@DeleteMapping("/deletebooking/{bookingId}")
	public ResponseEntity<Void> deleteBooking(@PathVariable String bookingId) {
		try {
			bookMovieService.deleteBooking(bookingId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (InvalidEntityException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Booking>> getAllBookings() {
		List<Booking> bookings = bookMovieService.viewAll();
		return new ResponseEntity<>(bookings, HttpStatus.OK);
	}

	@GetMapping("/viewById/{bookingId}")
	public ResponseEntity<?> getBookingById(@PathVariable String bookingId) {
		try {
			Optional<Booking> booking = bookMovieService.viewBookingById(bookingId);
			String successMessage = "BookMovie Id " + bookingId + " details retrieved successfully";

			return new ResponseEntity<>(booking, HttpStatus.OK);
		} catch (InvalidEntityException e) {
			String errorMessage = "BookMovie Id " + bookingId + " does not exist";

			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		}
	}

}
