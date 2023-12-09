package com.igaogl.moviemaster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIE")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @NotNull(message = "Movie name cannot be null.")
    @Column(name = "MOVIE_NAME")
    private String movieName; 
    // private User user;

    @NotNull(message = "Movie Year cannot be null.")
    @Column(name = "MOVIE_YEAR")
    private int year;

    @NotNull(message = "Genre cannot be null.")
    @Column(name = "MOVIE_GENRE")
    private String genre;

    @NotNull(message = "Movie rating cannot be null.")
    @Column(name = "MOVIE_RATING")
    private int rating;

    public Movie(){}

    public Movie(int movieId, String movieName, int year, String genre, int rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
