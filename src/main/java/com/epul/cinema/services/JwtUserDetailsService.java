package com.epul.cinema.services;

import com.epul.cinema.domains.User;
import com.epul.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository utilisateurRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User unUtilisateur = null;
        // on accède à l'utilisateur
        unUtilisateur = utilisateurRepository.findLogin(s);
        if (unUtilisateur != null) {
            return new org.springframework.security.core.userdetails.User(unUtilisateur.getLogin(), unUtilisateur.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + s);
        }

    }
}
