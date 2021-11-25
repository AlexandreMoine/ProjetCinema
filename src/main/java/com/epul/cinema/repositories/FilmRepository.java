package com.epul.cinema.repositories;

import com.epul.cinema.domains.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

    @Query("SELECT f FROM FilmEntity f WHERE f.realisateur.noRea = :noRea")
    List<FilmEntity> getFilmsByRealisateur(@Param("noRea") int noRea);

}
