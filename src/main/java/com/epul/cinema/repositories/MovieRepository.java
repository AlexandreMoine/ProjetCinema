package com.epul.cinema.repositories;

import com.epul.cinema.models.Movie;
import com.epul.cinema.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT movies FROM Movie movies WHERE movies.director.id = :director_id")
    List<Movie> getMoviesByDirector(@Param("director_id") long director_id);

    @Query("SELECT movies FROM Movie movies WHERE movies.title = :title")
    Movie getMoviesByTitle(@Param("title") String title);

    @Query("SELECT movies FROM Movie movies WHERE movies.releaseDate >= :startDate AND movies.releaseDate <= :endDate " +
            "ORDER BY movies.releaseDate DESC")
    List<Movie> getMoviesByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Movie> findByCategories_Code(String code);

}
