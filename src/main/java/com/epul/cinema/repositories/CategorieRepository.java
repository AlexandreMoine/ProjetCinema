package com.epul.cinema.repositories;

import com.epul.cinema.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Category, Integer> {
}
