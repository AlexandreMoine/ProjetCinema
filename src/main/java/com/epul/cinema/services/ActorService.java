package com.epul.cinema.services;

import com.epul.cinema.models.Actor;
import com.epul.cinema.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


}
