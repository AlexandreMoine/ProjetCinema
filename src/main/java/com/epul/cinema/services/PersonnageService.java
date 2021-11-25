package com.epul.cinema.services;

import com.epul.cinema.domains.MovieCharacter;
import com.epul.cinema.repositories.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class PersonnageService {

    private PersonnageRepository personnageRepository;

    @Autowired
    public PersonnageService(PersonnageRepository personnageRepository) {
        this.personnageRepository = personnageRepository;
    }

    public List<MovieCharacter> getPersonnagesByFilm(int noFilm) {
        return this.personnageRepository.getPersonnagesByFilm(noFilm);
    }

    public List<MovieCharacter> getPersonnagesByActeur(int noAct) {
        return this.personnageRepository.getPersonnagesByActeur(noAct);
    }

}
