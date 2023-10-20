package com.capg.movieapp.repository;

 

import com.capg.movieapp.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

 

public interface ScreeningRepository extends JpaRepository<Screening, String> {

 

    // Custom query to find screenings with screeningDate between fromDate and toDate
    @Query("SELECT s FROM Screening s WHERE s.fromDate <= :screeningDate AND s.toDate >= :screeningDate")
    List<Screening> findScreeningsByFromDateBeforeAndToDateAfter(@Param("screeningDate") LocalDate screeningDate);

 

    // Custom query to find screenings by movie name and city
    List<Screening> findScreeningsByMovieObj_MovieNameAndTheatreObj_City(String movieName, String city);

 

    // Custom query to find screenings by theatre name
    List<Screening> findScreeningsByTheatreObj_TheatreName(String theatreName);

 

   

   
}