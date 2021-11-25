package com.epul.cinema.repositories;

import com.epul.cinema.domains.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT f FROM Movie f WHERE f.director.id = :noRea")
    List<Movie> getFilmsByRealisateur(@Param("noRea") int noRea);

}
