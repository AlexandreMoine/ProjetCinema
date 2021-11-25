package com.epul.cinema.repositories;

import com.epul.cinema.domains.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {

    @Query("SELECT characters FROM MovieCharacter characters WHERE characters.movie.id = :movie_id")
    List<MovieCharacter> getCharactersByMovie(@Param("movie_id") long movie_id);

    @Query("SELECT characters FROM MovieCharacter characters WHERE characters.actor.id = :actor_id")
    List<MovieCharacter> getCharactersByActor(@Param("actor_id") long actor_id);

}
