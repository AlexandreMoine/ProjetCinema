package com.epul.cinema.repositories;

import com.epul.cinema.models.Category;
import com.epul.cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT categories FROM Category categories WHERE categories.code = :code")
    Category findByCode(@Param("code") String code);
}
