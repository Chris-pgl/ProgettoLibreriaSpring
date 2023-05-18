package com.example.demoProgettoLibreriaSpring.security.controller;

import com.example.demoProgettoLibreriaSpring.security.securityEntity.SignupDTO;
import com.example.demoProgettoLibreriaSpring.security.securityServiice.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    @Autowired
    private SecurityService securityService;



    //Signup
    //creazione nuovo utente
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignupDTO signupDTO){
        try{
            return ResponseEntity.ok(securityService.signup(signupDTO));
        }catch (Exception e){
            //TODO log exception
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Activation

    //Login

    //Recupero Password


}
