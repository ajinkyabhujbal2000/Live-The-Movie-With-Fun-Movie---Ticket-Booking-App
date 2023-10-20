package com.capg.movieapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "movie")
public class Movie {

	// Attributes //
	
    @Id                                  // primary key
    @Column(name = "movie_id")           // column name
    @NotBlank(message = "Provide value for movie id")
    private String movieId;

    @Column(name = "movie_name")
    @NotBlank(message = "Provide value for movie name")
    private String movieName;

    @Column(name = "director_name")
    @NotBlank(message = "Provide value for director name")
    private String directorName;

    @Column(name = "language")
    @NotBlank(message = "Provide value for language")
    private String language;

    @Column(name = "certification")
    @NotBlank(message = "Provide value for certification name")
    @Pattern(regexp = "^(U|U/A|A)$", message = "Certification can take the values U, U-A, A")
    private String certification;

    @Column(name = "duration")
    @Min(value = 60, message = "Duration should be at least 60 minutes")
    @Max(value = 200, message = "Duration should be at most 200 minutes")
    private int duration;

    @Column(name = "movie_rating")
    @DecimalMin(value = "0.0", message = "Provide a valid movieRating")
    @DecimalMax(value = "10.0", message = "Provide a valid movieRating")
    private double movieRating;
    	
    // Getters and Setters //

    public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}


}
