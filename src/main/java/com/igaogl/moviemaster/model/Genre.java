package com.igaogl.moviemaster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "GENRE")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENRE_ID")
    private int genreId;

    @Column(name = "GENRE")
    @NotEmpty(message = "Genre cannot be null.")
    private String genre;

    // private Collection<Movie> moviesByGenreCollection;

    public Genre() {
    }

    public Genre(int genreId, String genre) {
        this.genreId = genreId;
        this.genre = genre;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // public Collection<Movie> getMoviesByGenreCollection() {
    //     return moviesByGenreCollection;
    // }

    // public void setMoviesByGenreCollection(Collection<Movie> moviesByGenreCollection) {
    //     this.moviesByGenreCollection = moviesByGenreCollection;
    // }

}