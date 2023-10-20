package com.capg.movieapp.dao;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Booking;
//import com.capg.movieapp.model.Customer;

public interface BookMovieDAO {
	
	public Booking addBooking(Booking booking) ;
	
	public Booking deleteBooking(String bookingId) throws InvalidEntityException;
	public List<Booking> viewAll();
	public Optional<Booking>  viewBookingById(String bookingId);
	public List<Booking>  viewBookingByBookingDate(LocalDate bookingDate);

	Booking updateBookingCost(String bookingId, double amount) ;
}
