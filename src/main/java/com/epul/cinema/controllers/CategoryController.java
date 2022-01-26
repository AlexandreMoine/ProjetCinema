package com.epul.cinema.controllers;

import com.epul.cinema.models.Actor;
import com.epul.cinema.models.Category;
import com.epul.cinema.services.ActorService;
import com.epul.cinema.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> list() {
        List<Category> categories = null;
        try {
            categories = this.categoryService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return categories;
    }


    @PostMapping()
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Category create(@RequestBody Category category, HttpServletResponse response){
        Category createdCategory = categoryService.create(category);
        response.setStatus(HttpStatus.CREATED.value());
        return createdCategory;
    }

    @PutMapping("/{code}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Category update(@PathVariable String code, @RequestBody Category category){
        return this.categoryService.update(code, category);
    }

    @PostMapping("/delete/{code}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public ResponseEntity<Object> delete(@PathVariable String code){
        try {
            this.categoryService.delete(code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("Category with code = %s is deleted successfully", code), HttpStatus.OK);
    }




}
