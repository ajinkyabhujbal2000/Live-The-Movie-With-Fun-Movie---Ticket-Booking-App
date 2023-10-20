package com.capg.movieapp.dao;




import com.capg.movieapp.exception.InvalidEntityException;

import java.util.List;
import com.capg.movieapp.model.Theatre;

public interface TheatreDAO {
    
	Theatre addTheatre(Theatre theatre);
    

    List<Theatre> viewAll();
    
    Theatre updateTicketCost(String theatreId, String ticketCost) ;

    Theatre viewTheatreByID(String theatreId);

    List<Theatre> viewTheatreByCityAndTicketCost(String city, String ticketCost);



}

