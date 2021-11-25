package com.epul.cinema.repositories;

import com.epul.cinema.domains.ActeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<ActeurEntity, Integer> {
}
