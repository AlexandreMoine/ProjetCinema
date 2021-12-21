package com.epul.cinema.services;

import com.epul.cinema.models.Actor;
import com.epul.cinema.models.Movie;
import com.epul.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
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
        return this.movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Movie getByTitle(String title) {
        return this.movieRepository.getMoviesByTitle(title);
    }

    public List<Movie> listByDate(Date startDate, Date endDate) {
        return this.movieRepository.getMoviesByDate(startDate, endDate);
    }

    public List<Movie> listByCategory(String category) {
        return this.movieRepository.getMoviesByCategory(category);
    }

    public Movie create(Movie movie){
        return this.movieRepository.saveAndFlush(movie);
    }

    public Movie update(Long id, Movie movie){
        if (this.movieRepository.existsById(id)){
            movie.setId(id);
            return this.movieRepository.saveAndFlush(movie);
        }
        return this.create(movie);
    }

    public void delete(long id) {
        this.movieRepository.delete(this.get(id));
    }
}
