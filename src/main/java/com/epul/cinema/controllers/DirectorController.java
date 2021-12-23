package com.epul.cinema.controllers;

import com.epul.cinema.models.Actor;
import com.epul.cinema.models.Director;
import com.epul.cinema.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/directors")
public class DirectorController {

    private DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public List<Director> list() {
        List<Director> directors = null;
        try {
            directors = this.directorService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return directors;
    }

    @GetMapping("/{id}")
    public Director get(@PathVariable long id) {
        Director director = null;
        try {
            director = this.directorService.get(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return director;
    }

    @GetMapping("/firstname/{firstname}")
    public List<Director> getDirectorsByFirstname(@PathVariable String firstname) {
        List<Director> directors = null;
        try {
            directors = this.directorService.getDirectorsByFirstname(firstname);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return directors;
    }

    @GetMapping("/lastname/{lastname}")
    public List<Director> getDirectorsByLastname(@PathVariable String lastname) {
        List<Director> directors = null;
        try {
            directors = this.directorService.getDirectorsByLastname(lastname);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return directors;
    }



    @PostMapping()
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Director create(@RequestBody Director director, HttpServletResponse response) {
        Director createdDirector = directorService.create(director);
        response.setStatus(HttpStatus.CREATED.value());
        return createdDirector;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Director update(@PathVariable long id, @RequestBody Director director) {
        return this.directorService.update(id, director);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        try {
            this.directorService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("Director with id = %s is deleted successfully", id), HttpStatus.OK);
    }


}
