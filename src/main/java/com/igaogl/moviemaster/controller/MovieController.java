package com.igaogl.moviemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.igaogl.moviemaster.model.Movie;
import com.igaogl.moviemaster.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private @Autowired MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> postMovie(@Valid @RequestBody Movie movie) {
        try {
            Movie postedMovie = movieService.postMovie(movie)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie creation failed."));
            return ResponseEntity.status(HttpStatus.CREATED).body(postedMovie);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
        }
    }

}
