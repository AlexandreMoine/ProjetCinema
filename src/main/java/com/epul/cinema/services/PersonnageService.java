package com.epul.cinema.services;

import com.epul.cinema.domains.PersonnageEntity;
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

    public List<PersonnageEntity> getPersonnagesByFilm(int noFilm) {
        return this.personnageRepository.getPersonnagesByFilm(noFilm);
    }

    public List<PersonnageEntity> getPersonnagesByActeur(int noAct) {
        return this.personnageRepository.getPersonnagesByActeur(noAct);
    }

}
