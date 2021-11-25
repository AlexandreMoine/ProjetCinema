package com.epul.cinema.services;

import com.epul.cinema.domains.Movie;
import com.epul.cinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Movie> getFilms() {
        return this.filmRepository.findAll();
    }

    public List<Movie> getFilmsByRealisateur(int noRea) {
        return this.filmRepository.getFilmsByRealisateur(noRea);
    }

}
