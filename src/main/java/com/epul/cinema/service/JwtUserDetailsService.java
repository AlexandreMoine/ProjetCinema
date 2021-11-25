package com.epul.cinema.service;

import com.epul.cinema.domains.UtilisateurEntity;
import com.epul.cinema.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public JwtUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UtilisateurEntity unUtilisateur = null;
        // on accède à l'utilisateur
        unUtilisateur = utilisateurRepository.rechercheNom(s);
        if (unUtilisateur != null) {
            return new User(unUtilisateur.getNom(), unUtilisateur.getMdp(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + s);
        }

    }
}
