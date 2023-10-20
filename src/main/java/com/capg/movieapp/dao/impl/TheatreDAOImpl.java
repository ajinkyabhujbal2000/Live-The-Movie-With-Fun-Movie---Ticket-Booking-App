package com.capg.movieapp.dao.impl;

import com.capg.movieapp.model.Theatre;
import com.capg.movieapp.dao.TheatreDAO;
import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TheatreDAOImpl implements TheatreDAO {

    private final TheatreRepository theatreRepository;

    @Autowired
    public TheatreDAOImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }


    @Override
    public List<Theatre> viewAll() {
        return theatreRepository.findAll();
    }
    

  public Theatre updateTicketCost(String theatreId, String ticketCost)  {
      Optional<Theatre> optionalTheatre = theatreRepository.findById(theatreId);
     // if (optionalTheatre.isPresent()) {
          Theatre theatre = optionalTheatre.get();
          theatre.setTicketCost(ticketCost);
          return theatreRepository.save(theatre);

  }
  
  
	@Override
	public Theatre viewTheatreByID(String theatreId) throws InvalidEntityException {
	    Optional<Theatre> optionalTheatre = theatreRepository.findById(theatreId);
	    if (optionalTheatre.isPresent()) {
	        return optionalTheatre.get();
	    }else {
	        throw new InvalidEntityException("Theatre Id " + theatreId + " does not exist");
	    }
	}
	
	  @Override
    public List<Theatre> viewTheatreByCityAndTicketCost(String city, String ticketCost) {
        return theatreRepository.findByCityAndTicketCostLessThanEqual(city, ticketCost);
    }

	
	}
	  



