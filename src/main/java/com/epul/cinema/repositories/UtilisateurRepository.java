package com.epul.cinema.repositories;

import com.epul.cinema.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<User, Integer> {

    User findLogin(String login);

}
