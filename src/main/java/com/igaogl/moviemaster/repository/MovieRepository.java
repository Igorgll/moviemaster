package com.igaogl.moviemaster.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.igaogl.moviemaster.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByMovieNameIgnoreCase(String movieName);
}
