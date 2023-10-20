package com.capg.movieapp.service.impl;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.movieapp.dao.BookMovieDAO;
import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Booking;
import com.capg.movieapp.service.BookMovieService;
import com.capg.movieapp.service.BookMovieService;
@Service
public class BookMovieServiceImpl implements BookMovieService {

	private final BookMovieDAO bookMovieDAO;

	@Autowired
	public BookMovieServiceImpl(BookMovieDAO bookMovieDAO) {
		this.bookMovieDAO = bookMovieDAO;
	}

	@Override
	public Booking addBooking(Booking booking) throws InvalidEntityException {

		return bookMovieDAO.addBooking(booking);
	}

	@Override
	public Booking deleteBooking(String bookingId) throws InvalidEntityException {
		// TODO Auto-generated method stub
		return bookMovieDAO.deleteBooking(bookingId);
	}

	@Override
	public List<Booking> viewAll() {
		// TODO Auto-generated method stub
		return bookMovieDAO.viewAll();
	}

	@Override
	public Optional<Booking> viewBookingById(String bookingId) {
		// TODO Auto-generated method stub
		return bookMovieDAO.viewBookingById(bookingId);
	}

	@Override
	public List<Booking> viewBookingByBookingDate(LocalDate bookingDate) {
		// TODO Auto-generated method stub
		return bookMovieDAO.viewBookingByBookingDate(bookingDate);
	}

	@Override
	public Booking updateBookingCost(String bookingId, double amount) {
		// TODO Auto-generated method stub
		return bookMovieDAO.updateBookingCost(bookingId, amount);
	}

	
    

}
