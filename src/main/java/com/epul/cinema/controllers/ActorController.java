package com.epul.cinema.controllers;

import com.epul.cinema.domains.Actor;
import com.epul.cinema.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> list() {
        List<Actor> actors = null;
        try {
            actors = this.actorService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return actors;
    }


}
