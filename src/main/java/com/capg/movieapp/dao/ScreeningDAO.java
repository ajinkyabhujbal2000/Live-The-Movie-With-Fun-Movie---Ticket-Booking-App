package com.capg.movieapp.dao;

 

import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Screening;


 

import java.time.LocalDate;
import java.util.List;


 

public interface ScreeningDAO {

 

    Screening addScreening(Screening screening, String movieId, String theatreId) throws InvalidEntityException;

 

    Screening updateToDate(String screeningId, LocalDate toDate) throws InvalidEntityException;

 

    List<Screening> viewAll();

 

    Screening viewByScreenID(String screeningId) throws InvalidEntityException;

 


 

    List<Screening> viewScreeningByMovieNameAndCity(String movieName, String city);

 

    List<Screening> viewScreeningByTheatreName(String theatreName);

 

}