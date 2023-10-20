package com.capg.movieapp.dao.impl;

 

import com.capg.movieapp.dao.ScreeningDAO;
import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Screening;
import com.capg.movieapp.repository.MovieRepository;
import com.capg.movieapp.repository.ScreeningRepository;
import com.capg.movieapp.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

 

@Repository
public class ScreeningDAOImpl implements ScreeningDAO {

 

	@Autowired
    private final ScreeningRepository screeningRepository;
	@Autowired
    private final MovieRepository movieRepository;
	@Autowired
    private final TheatreRepository theatreRepository;

 

    @Autowired
    public ScreeningDAOImpl(ScreeningRepository screeningRepository, MovieRepository movieRepository, TheatreRepository theatreRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

 

    @Override
    public Screening addScreening(Screening screening, String movieId, String theatreId) throws InvalidEntityException {
        // Check if the provided movieId and theatreId exist in the database
        if (!movieRepository.existsById(movieId)) {
            throw new InvalidEntityException("Movie Id " + movieId + " is not found");
        }
        if (!theatreRepository.existsById(theatreId)) {
            throw new InvalidEntityException("Theatre Id " + theatreId + " is not found");
        }

 

        // Set the movie and theatre objects in the screening
        screening.setMovieObj(movieRepository.findById(movieId).orElse(null));
        screening.setTheatreObj(theatreRepository.findById(theatreId).orElse(null));

 

        // Save the screening in the database
        return screeningRepository.save(screening);
    }

 

    @Override
    public Screening updateToDate(String screeningId, LocalDate toDate) throws InvalidEntityException {
        // Check if the provided screeningId exists in the database
        Screening existingScreening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new InvalidEntityException("Screening Id " + screeningId + " does not exist"));

 

        // Update the toDate of the screening
        existingScreening.setToDate(toDate);

 

        // Save the updated screening in the database
        return screeningRepository.save(existingScreening);
    }

 

    @Override
    public List<Screening> viewAll() {
        // Retrieve all screenings from the database
        return screeningRepository.findAll();
    }

 

    @Override
    public Screening viewByScreenID(String screeningId) throws InvalidEntityException {
        // Check if the provided screeningId exists in the database
        return screeningRepository.findById(screeningId)
                .orElseThrow(() -> new InvalidEntityException("Screening Id " + screeningId + " does not exist"));
    }

 

 

 

    @Override
    public List<Screening> viewScreeningByMovieNameAndCity(String movieName, String city) 
    {
        // Retrieve screenings by movie name and city
        return screeningRepository.findScreeningsByMovieObj_MovieNameAndTheatreObj_City(movieName, city);
    }

 

    @Override
    public List<Screening> viewScreeningByTheatreName(String theatreName) 
    {
        // Retrieve screenings by theatre name
        return screeningRepository.findScreeningsByTheatreObj_TheatreName(theatreName);
    }




 

   
}