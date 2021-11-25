package com.epul.cinema.services;

import com.epul.cinema.domains.Actor;
import com.epul.cinema.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class ActeurService {

    private ActeurRepository acteurRepository;

    @Autowired
    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<Actor> getActeurs() {
        return this.acteurRepository.findAll();
    }


}
