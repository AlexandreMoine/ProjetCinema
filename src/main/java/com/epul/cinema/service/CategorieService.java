package com.epul.cinema.service;

import com.epul.cinema.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {

    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }



}
