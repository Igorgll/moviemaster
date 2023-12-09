package com.igaogl.moviemaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.igaogl.moviemaster.model.Movie;
import com.igaogl.moviemaster.repository.MovieRepository;

@Service
public class MovieService {

    private @Autowired MovieRepository movieRepository;

    public Optional<Movie> postMovie(Movie movie) {
        Optional<Movie> newMovie = movieRepository.findByMovieNameIgnoreCase(movie.getMovieName());

        if (newMovie.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Movie with name: " + movie.getMovieName() + " already exists.", null);
        }

        return Optional.ofNullable(movieRepository.save(movie));

    }
}
