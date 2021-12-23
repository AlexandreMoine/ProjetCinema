package com.epul.cinema.services;

import com.epul.cinema.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epul.cinema.models.Director;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> list() {
        return this.directorRepository.findAll();
    }

    public Director get(long id) {
        return this.directorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public List<Director> getDirectorsByFirstname(String firstname) {
        return this.directorRepository.getDirectorsByFirstname(firstname);
    }

    public List<Director> getDirectorsByLastname(String lastname) {
        return this.directorRepository.getDirectorsByLastname(lastname);
    }

    public Director create(Director director) {
        return this.directorRepository.saveAndFlush(director);
    }

    public Director update(long id, Director director) {
        if(this.directorRepository.existsById(id)) {
            director.setId(id);
        }
        return this.create(director);
    }

    public void delete(long id) {
        this.directorRepository.deleteById(id);
    }


}
