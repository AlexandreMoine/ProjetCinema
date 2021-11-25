package com.epul.cinema.repositories;

import com.epul.cinema.domains.PersonnageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnageRepository extends JpaRepository<PersonnageEntity, Integer> {

    @Query("SELECT p FROM PersonnageEntity p WHERE p.filmByNoFilm.noFilm = :noFilm")
    List<PersonnageEntity> getPersonnagesByFilm(@Param("noFilm") int noFilm);

    @Query("SELECT p FROM PersonnageEntity p WHERE p.acteurByNoAct.noAct = :noAct")
    List<PersonnageEntity> getPersonnagesByActeur(@Param("noAct") int noAct);

}
