package com.epul.cinema.controllers;

import com.epul.cinema.domains.Actor;
import com.epul.cinema.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/acteur")
public class ActeurController {

    @Autowired
    private ActorService acteurService;

    @GetMapping("/getActeurs")
    public List<Actor> getActeurs() {
        List<Actor> acteurs = null;
        try {
            acteurs = this.acteurService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return acteurs;
    }


}
