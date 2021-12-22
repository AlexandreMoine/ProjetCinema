package com.epul.cinema.services;

import com.epul.cinema.models.Actor;
import com.epul.cinema.models.Category;
import com.epul.cinema.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> list() {
        return this.categoryRepository.findAll();
    }

}
