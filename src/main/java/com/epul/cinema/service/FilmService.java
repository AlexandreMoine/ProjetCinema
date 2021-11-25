package com.epul.cinema.service;

import com.epul.cinema.domains.FilmEntity;
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

    public List<FilmEntity> getFilms() {
        return this.filmRepository.findAll();
    }

    public List<FilmEntity> getFilmsByRealisateur(int noRea) {
        return this.filmRepository.getFilmsByRealisateur(noRea);
    }

}
