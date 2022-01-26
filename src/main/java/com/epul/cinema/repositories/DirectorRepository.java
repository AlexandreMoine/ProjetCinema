package com.epul.cinema.repositories;

import com.epul.cinema.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    public List<Director> getDirectorsByFirstname(String firstname);

    public List<Director> getDirectorsByLastname(String lastname);

}
