package com.capg.movieapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Booking;

public interface BookMovieService {

	public Booking addBooking(Booking booking) throws InvalidEntityException;

	public Booking deleteBooking(String bookingId) throws InvalidEntityException;

	public List<Booking> viewAll();

	public Optional<Booking> viewBookingById(String bookingId);

	public List<Booking> viewBookingByBookingDate(LocalDate bookingDate);

	

	public Booking updateBookingCost(String bookingId, double amount);
}
