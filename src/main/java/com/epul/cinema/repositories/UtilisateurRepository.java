package com.epul.cinema.repositories;

import com.epul.cinema.domains.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity rechercheNom(String login);

}
