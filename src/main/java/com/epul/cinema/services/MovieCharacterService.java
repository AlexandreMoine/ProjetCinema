package com.epul.cinema.services;

import com.epul.cinema.models.MovieCharacter;
import com.epul.cinema.repositories.MovieCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class MovieCharacterService {

    private MovieCharacterRepository movieCharacterRepository;

    @Autowired
    public MovieCharacterService(MovieCharacterRepository movieCharacterRepository) {
        this.movieCharacterRepository = movieCharacterRepository;
    }

    public List<MovieCharacter> listByMovie(long movie_id) {
        return this.movieCharacterRepository.getCharactersByMovie(movie_id);
    }

    public List<MovieCharacter> listByActor(long actor_id) {
        return this.movieCharacterRepository.getCharactersByActor(actor_id);
    }

}
