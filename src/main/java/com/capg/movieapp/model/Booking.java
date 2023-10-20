package com.capg.movieapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@Column(name = "booking_id")
	@NotBlank(message = "Provide value for booking_id")
	private String bookingId;

	@Column(name = "booking_date")
	
	private LocalDate bookingDate;

	@Column(name = "show_time")
	@NotBlank(message = "Provide value for show_time")
	private String showTime;

	@Column(name = "number_of_tickets")
	@Min(value = 1, message = "number_of_tickets should be at least 1")
	@Max(value = 25, message = "number_of_tickets should be at most 25")
	private int numberOfTickets;

	@Column(name = "amount")
	private double amount;

	public Booking() {
		// Default constructor
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Booking(String bookingId, LocalDate bookingDate, String showTime, int numberOfTickets, double amount) {
		super();

		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.showTime = showTime;
		this.numberOfTickets = numberOfTickets;
		this.amount = amount;

	}

}
