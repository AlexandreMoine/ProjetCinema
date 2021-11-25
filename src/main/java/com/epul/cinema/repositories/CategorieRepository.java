package com.epul.cinema.repositories;

import com.epul.cinema.domains.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity, Integer> {
}
