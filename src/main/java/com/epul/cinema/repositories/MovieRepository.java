package com.epul.cinema.repositories;

import com.epul.cinema.domains.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT movies FROM Movie movies WHERE movies.director.id = :director_id")
    List<Movie> getMoviesByDirector(@Param("director_id") long director_id);

}
