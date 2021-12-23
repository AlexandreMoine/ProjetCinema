package com.epul.cinema.controllers;

import com.epul.cinema.models.Actor;
import com.epul.cinema.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("/{id}")
    public Actor get(@PathVariable long id){
        actorService.get(id);
        Actor actor = null;
        try{
            actor = this.actorService.get(id);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return actor;
    }

    @GetMapping("/firstname/{firstname}")
    public List<Actor> getActorsByFirstname(@PathVariable String firstname) {
        List<Actor> actors = null;
        try{
            actors = this.actorService.getActorsByFirstname(firstname);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return actors;
    }

    @GetMapping("/lastname/{lastname}")
    public List<Actor> getActorsByLastname(@PathVariable String lastname) {
        List<Actor> actors = null;
        try{
            actors = this.actorService.getActorsByLastname(lastname);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return actors;
    }

    @GetMapping("/character_firstname/{firstname}")
    public List<Actor> getActorsByCharacterFirstname(@PathVariable String firstname) {
        List<Actor> actors = null;
        try{
            actors = this.actorService.getActorsByCharacterFirstname(firstname);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return actors;
    }

    @GetMapping("/character_lastname/{lastname}")
    public List<Actor> getActorsByCharacterLastname(@PathVariable String lastname) {
        List<Actor> actors = null;
        try{
            actors = this.actorService.getActorsByCharacterLastname(lastname);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return actors;
    }


    @PostMapping()
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Actor create(@RequestBody Actor actor, HttpServletResponse response){
        Actor createdActor = actorService.create(actor);
        response.setStatus(HttpStatus.CREATED.value());
        return createdActor;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Actor update(@PathVariable long id, @RequestBody Actor actor){
        return this.actorService.update(id, actor);
    }

    // TODO pas ouf si l'acteur est référencé ailleur dans la base
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public ResponseEntity<Object> delete(@PathVariable long id){
        try {
            this.actorService.delete(id);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("Actor with id = %s is deleted successfully", id), HttpStatus.OK);
    }


}
