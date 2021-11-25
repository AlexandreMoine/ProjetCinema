package com.epul.cinema.service;

import com.epul.cinema.repositories.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealisateurService {

    private RealisateurRepository realisateurRepository;

    @Autowired
    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }



}
