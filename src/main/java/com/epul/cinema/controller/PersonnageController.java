package com.epul.cinema.controller;

import com.epul.cinema.domains.PersonnageEntity;
import com.epul.cinema.service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnage")
public class PersonnageController {

    @Autowired
    private PersonnageService personnageService;

    @GetMapping("/getPersonnagesByFilm/{noFilm}")
    public List<PersonnageEntity> getPersonnagesByFilm(@PathVariable int noFilm) {
        List<PersonnageEntity> personnages = null;

        try {
            personnages = personnageService.getPersonnagesByFilm(noFilm);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }

        return personnages;
    }


    @GetMapping("/getPersonnagesByActeur/{noAct}")
    public List<PersonnageEntity> getPersonnagesByActeur(@PathVariable int noAct) {
        List<PersonnageEntity> personnages = null;

        try {
            personnages = personnageService.getPersonnagesByActeur(noAct);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }

        return personnages;
    }


}
