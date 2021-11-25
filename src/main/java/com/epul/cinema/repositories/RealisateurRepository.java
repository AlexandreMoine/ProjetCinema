package com.epul.cinema.repositories;

import com.epul.cinema.domains.RealisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<RealisateurEntity, Integer> {
}
