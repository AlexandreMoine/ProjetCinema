package com.epul.cinema.controllers;

import com.epul.cinema.models.*;
import com.epul.cinema.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Movie> list() {
        List<Movie> movies = null;
        try {
            movies = this.movieService.list();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return movies;
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable long id){
        Movie movie = null;
        try{
            movie = this.movieService.get(id);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return movie;
    }

    @GetMapping("/getByTitle/{title}")
    public Movie get(@PathVariable String title){
        Movie movie = null;
        try{
            movie = this.movieService.getByTitle(title);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return movie;
    }

    @GetMapping("/getByDate")
    public List<Movie> getByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
        List<Movie> movies = null;
        try{
            movies = this.movieService.listByDate(Date.valueOf(startDate), Date.valueOf(endDate));
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return movies;
    }

    @GetMapping("/getByCategory/{code}")
    public List<Movie> getByCategory(@PathVariable String code){
        List<Movie> movies = null;
        try{
            movies = this.movieService.listByCategory(code);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return movies;
    }

    // TODO pas certains pour le nom de la route
    @GetMapping("/directors/{director_id}")
    public List<Movie> listByDirector(@PathVariable int director_id) {
        List<Movie> movies = null;
        try {
            movies = this.movieService.listByDirector(director_id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return movies;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Movie update(@PathVariable long id, @RequestBody Movie movie){
        return this.movieService.update(id, movie);
    }

    @PostMapping()
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public Movie create(@RequestBody Movie movie, HttpServletResponse response){
        System.out.println(movie);
        Movie createdMovie = movieService.create(movie);
        response.setStatus(HttpStatus.CREATED.value());
        return createdMovie;
    }

    // TODO pas ouf si le film est référencé ailleurs dans la base
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('MODERATOR') || hasRole('ADMIN')")
    public ResponseEntity<Object> delete(@PathVariable long id){
        try {
            this.movieService.delete(id);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("Film with id = %s is deleted successfully", id), HttpStatus.OK);
    }

}
