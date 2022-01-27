package com.epul.cinema.controllers;

import com.epul.cinema.models.Movie;
import com.epul.cinema.models.MovieCharacter;
import com.epul.cinema.services.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/characters")
public class MovieCharacterController {

    @Autowired
    private MovieCharacterService movieCharacterService;

    @GetMapping
    public List<MovieCharacter> list() {
        List<MovieCharacter> characters = null;
        try {
            characters = this.movieCharacterService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return characters;
    }

    @GetMapping("/movies/{movie_id}")
    public List<MovieCharacter> listByMovie(@PathVariable int movie_id) {
        List<MovieCharacter> characters = null;

        try {
            characters = movieCharacterService.listByMovie(movie_id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }

        return characters;
    }


    @GetMapping("/actors/{actor_id}")
    public List<MovieCharacter> listByActor(@PathVariable int actor_id) {
        List<MovieCharacter> characters = null;

        try {
            characters = movieCharacterService.listByActor(actor_id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }

        return characters;
    }
}
