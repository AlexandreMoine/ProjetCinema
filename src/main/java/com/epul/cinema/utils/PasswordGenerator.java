package com.epul.cinema.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static String generate(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //Le mot de passe à encoder avec la méthode BCryptPasswordEncoder
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String hash = PasswordGenerator.generate("123");
        System.out.println(hash);
    }
}