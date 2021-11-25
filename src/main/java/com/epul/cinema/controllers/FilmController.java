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
    private FilmService filmService;

    @GetMapping("/getFilms")
    public List<FilmEntity> getFilms() {
        List<FilmEntity> films = null;
        try {
            films = this.filmService.getFilms();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return films;
    }


    @GetMapping("/getFilmsByRealisateur/{noRea}")
    public List<FilmEntity> getFilmsByRealisateur(@PathVariable int noRea) {
        List<FilmEntity> films = null;
        try {
            films = this.filmService.getFilmsByRealisateur(noRea);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return films;
    }

}
