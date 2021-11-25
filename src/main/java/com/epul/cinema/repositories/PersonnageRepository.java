package com.epul.cinema.repositories;

import com.epul.cinema.domains.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnageRepository extends JpaRepository<MovieCharacter, Integer> {

    @Query("SELECT p FROM MovieCharacter p WHERE p.movie.id = :noFilm")
    List<MovieCharacter> getPersonnagesByFilm(@Param("noFilm") int noFilm);

    @Query("SELECT p FROM MovieCharacter p WHERE p.actor.id = :noAct")
    List<MovieCharacter> getPersonnagesByActeur(@Param("noAct") int noAct);

}
