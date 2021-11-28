package com.epul.cinema.services;

import com.epul.cinema.models.Actor;
import com.epul.cinema.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;


@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository acteurRepository) {
        this.actorRepository = acteurRepository;
    }

    public List<Actor> list() {
        return this.actorRepository.findAll();
    }

    public Actor get(Long id){
        return this.actorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Actor create(Actor actor){
        return this.actorRepository.saveAndFlush(actor);
    }

    public Actor update(Long id, Actor actor){
        if (this.actorRepository.existsById(id)){
            actor.setId(id);
            return this.actorRepository.saveAndFlush(actor);
        }
        return this.create(actor);
    }

    public void delete(long id) {
        Actor actor = this.get(id);
        this.actorRepository.delete(actor);
    }
}
