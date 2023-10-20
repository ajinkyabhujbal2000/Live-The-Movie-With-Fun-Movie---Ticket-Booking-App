package com.capg.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.movieapp.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

	List<Movie> findByDirectorNameAndCertification(String directorName, String certification);

	@Query("SELECT m.directorName,COUNT(m) FROM Movie m GROUP BY m.directorName")
	List<Object[]> findByCountDirectorwise();
    
}
