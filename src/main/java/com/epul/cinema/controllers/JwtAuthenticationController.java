package com.epul.cinema.controllers;

import com.epul.cinema.domains.User;
import com.epul.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.epul.cinema.services.JwtUserDetailsService;
import com.epul.cinema.utils.JwtTokenUtil;
import com.epul.cinema.domains.JwtResponse;

@RequestMapping
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    private UserRepository utilisateurRepository;

    @Autowired
    public JwtAuthenticationController(UserRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User util) throws Exception {
        try {
            UserDetails details = appelAuthentication(util.getLogin(), util.getPassword());
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
