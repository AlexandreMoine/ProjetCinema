package com.epul.cinema.controllers;

import com.epul.cinema.domains.ActeurEntity;
import com.epul.cinema.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/acteur")
public class ActeurController {

    @Autowired
    private ActeurService acteurService;

    @GetMapping("/getActeurs")
    public List<ActeurEntity> getActeurs() {
        List<ActeurEntity> acteurs = null;
        try {
            acteurs = this.acteurService.getActeurs();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return acteurs;
    }


}
