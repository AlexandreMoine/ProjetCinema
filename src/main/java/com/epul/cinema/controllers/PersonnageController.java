package com.epul.cinema.controllers;

import com.epul.cinema.domains.MovieCharacter;
import com.epul.cinema.services.PersonnageService;
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
    public List<MovieCharacter> getPersonnagesByFilm(@PathVariable int noFilm) {
        List<MovieCharacter> personnages = null;

        try {
            personnages = personnageService.getPersonnagesByFilm(noFilm);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }

        return personnages;
    }


    @GetMapping("/getPersonnagesByActeur/{noAct}")
    public List<MovieCharacter> getPersonnagesByActeur(@PathVariable int noAct) {
        List<MovieCharacter> personnages = null;

        try {
            personnages = personnageService.getPersonnagesByActeur(noAct);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }

        return personnages;
    }


}
