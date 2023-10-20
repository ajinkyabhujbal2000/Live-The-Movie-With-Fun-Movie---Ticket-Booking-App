package com.capg.movieapp.service.impl;

 

import com.capg.movieapp.dao.ScreeningDAO;
import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Screening;
import com.capg.movieapp.service.ScreeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

 

@Service
public class ScreeningServiceImpl implements ScreeningService {

 

    private final ScreeningDAO screeningDAO;

 

    @Autowired
    public ScreeningServiceImpl(ScreeningDAO screeningDAO) {
        this.screeningDAO = screeningDAO;
    }

 

    @Override
    @Transactional
    public Screening addScreening(Screening screening, String movieId, String theatreId) throws InvalidEntityException {
        
        return screeningDAO.addScreening(screening, movieId, theatreId);
    }

 

    @Override
    @Transactional
    public Screening updateToDate(String screeningId, LocalDate toDate) throws InvalidEntityException {
       
        return screeningDAO.updateToDate(screeningId, toDate);
    }

 

    @Override
    @Transactional(readOnly = true)
    public List<Screening> viewAll() {
        return screeningDAO.viewAll();
    }

 

    @Override
    @Transactional(readOnly = true)
    public Screening viewByScreenID(String screeningId) throws InvalidEntityException {
        
        return screeningDAO.viewByScreenID(screeningId);
    }

 

   

 

    @Override
    @Transactional(readOnly = true)
    public List<Screening> viewScreeningByMovieNameAndCity(String movieName, String city) {
        return screeningDAO.viewScreeningByMovieNameAndCity(movieName, city);
    }

 

    @Override
    @Transactional(readOnly = true)
    public List<Screening> viewScreeningByTheatreName(String theatreName) {
        return screeningDAO.viewScreeningByTheatreName(theatreName);
    }

 


 


}