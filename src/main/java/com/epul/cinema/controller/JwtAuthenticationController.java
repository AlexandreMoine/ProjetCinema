package com.epul.cinema.controller;

import java.util.Objects;

import com.epul.cinema.domains.UtilisateurEntity;
import com.epul.cinema.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.epul.cinema.service.JwtUserDetailsService;
import com.epul.cinema.config.JwtTokenUtil;
import com.epul.cinema.domains.JwtResponse;

@RequestMapping("/authentification")
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public JwtAuthenticationController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UtilisateurEntity util) throws Exception {
        try {
            UserDetails details = appelAuthentication(util.getNom(), util.getMdp());
            final String token = jwtTokenUtil.generateToken(details);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private UserDetails appelAuthentication(String username, String password) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails;
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }



}
