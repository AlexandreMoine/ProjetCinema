package com.epul.cinema.controllers;

import com.epul.cinema.domains.*;
import com.epul.cinema.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> list() {
        List<Movie> movies = null;
        try {
            movies = this.movieService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return movies;
    }


    // TODO pas certains pour le nom de la route
    @GetMapping("/directors/{director_id}")
    public List<Movie> listByDirector(@PathVariable int director_id) {
        List<Movie> movies = null;
        try {
            movies = this.movieService.listByDirector(director_id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return movies;
    }

}
