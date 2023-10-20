package com.capg.movieapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.movieapp.model.Booking;

@Repository
public interface BookMovieRepository extends JpaRepository<Booking, String> {

	List<Booking> findByBookingDate(LocalDate bookingDate);

	Optional<Booking> findById(String bookingId);

}
