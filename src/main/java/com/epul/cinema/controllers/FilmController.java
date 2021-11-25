package com.epul.cinema.controllers;

import com.epul.cinema.domains.*;
import com.epul.cinema.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private MovieService filmService;

    @GetMapping("/getFilms")
    public List<Movie> getFilms() {
        List<Movie> films = null;
        try {
            films = this.filmService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return films;
    }


    @GetMapping("/getFilmsByRealisateur/{noRea}")
    public List<Movie> getFilmsByRealisateur(@PathVariable int noRea) {
        List<Movie> films = null;
        try {
            films = this.filmService.listByDirector(noRea);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return films;
    }

}
