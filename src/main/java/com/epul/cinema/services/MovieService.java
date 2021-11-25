package com.epul.cinema.services;

import com.epul.cinema.domains.Movie;
import com.epul.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> list() {
        return this.movieRepository.findAll();
    }

    public List<Movie> listByDirector(long director_id) {
        return this.movieRepository.getMoviesByDirector(director_id);
    }

    public Movie get(long id) {
        return this.movieRepository.getOne(id);
    }
}
