package com.epul.cinema.repositories;

import com.epul.cinema.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    public List<Actor> getActorsByFirstname(String firstname);

    public List<Actor> getActorsByLastname(String lastname);

    @Query("SELECT a FROM Actor a, MovieCharacter mc WHERE a.id = mc.actor.id AND mc.firstname = :firstname")
    public List<Actor> getActorsByCharacterFirstname(String firstname);

    @Query("SELECT a FROM Actor a, MovieCharacter mc WHERE a.id = mc.actor.id AND mc.lastname = :lastname")
    public List<Actor> getActorsByCharacterLastname(String lastname);

}
