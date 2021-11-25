package com.epul.cinema.repositories;

import com.epul.cinema.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findLogin(String login);
}
