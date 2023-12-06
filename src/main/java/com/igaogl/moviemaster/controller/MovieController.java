package com.igaogl.moviemaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MovieController {

    @GetMapping
    public String helloMoviesMaster() {
        return "Hello Movies Master";
    }
}
