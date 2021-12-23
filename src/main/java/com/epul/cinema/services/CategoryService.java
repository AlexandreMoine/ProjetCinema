package com.epul.cinema.services;

import com.epul.cinema.models.Actor;
import com.epul.cinema.models.Category;
import com.epul.cinema.models.Movie;
import com.epul.cinema.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category get(String code) {
        return this.categoryRepository.findByCode(code);
    }

    public List<Category> list() {
        return this.categoryRepository.findAll();
    }

    public Category create(Category category) {
        return this.categoryRepository.saveAndFlush(category);
    }

    public Category update(String code, Category category) {
        if(this.categoryRepository.existsById(code)) {
            category.setCode(code);
        }
        return this.create(category);
    }

    public void delete(String code) {
        this.categoryRepository.deleteById(code);
    }

}
