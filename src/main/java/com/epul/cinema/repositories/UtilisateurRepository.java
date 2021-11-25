package com.epul.cinema.repositories;

import com.epul.cinema.domains.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {

    UtilisateurEntity rechercheNom(String login);

}
