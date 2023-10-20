
package com.capg.movieapp.service.impl;


import com.capg.movieapp.exception.InvalidEntityException;

import java.util.List;
import com.capg.movieapp.model.Theatre;

import com.capg.movieapp.dao.TheatreDAO;
import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Theatre;
import com.capg.movieapp.service.TheatreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  TheatreServiceImpl implements TheatreService{

    private final TheatreDAO theatreDAO;

    @Autowired
    public TheatreServiceImpl(TheatreDAO theatreDAO) {
        this.theatreDAO = theatreDAO;
    }

    public Theatre addTheatre(Theatre theatre) {
        return theatreDAO.addTheatre(theatre);
    }


    public List<Theatre> viewAll() {
        return theatreDAO.viewAll();
    }
    
	  public Theatre updateTicketCost(String theatreId, String ticketCost)  {
	  return theatreDAO.updateTicketCost(theatreId, ticketCost);
	}
	  
	    public Theatre viewTheatreByID(String theatreId)  {
	    return theatreDAO.viewTheatreByID(theatreId);
	}
	    
	    public List<Theatre> viewTheatreByCityAndTicketCost(String city, String ticketCost) {
	        return theatreDAO.viewTheatreByCityAndTicketCost(city, ticketCost);
	    }
	    


}

