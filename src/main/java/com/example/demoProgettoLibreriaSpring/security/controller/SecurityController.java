package com.example.demoProgettoLibreriaSpring.security.controller;

import com.example.demoProgettoLibreriaSpring.security.securityEntity.*;
import com.example.demoProgettoLibreriaSpring.security.securityServiice.LoginService;
import com.example.demoProgettoLibreriaSpring.security.securityServiice.PasswordService;
import com.example.demoProgettoLibreriaSpring.security.securityServiice.SignupService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {


        private BCryptPasswordEncoder encoder;
        @Autowired
        private SignupService signupService;

        @Autowired
        private LoginService loginService;

        @Autowired
        private PasswordService passwordService;


        //Signup
        //creazione nuovo utente
        @PostMapping("/signup")
        public ResponseEntity signUp(@RequestBody SignupDTO signupDTO) {
            try {
                return ResponseEntity.ok(signupService.signup(signupDTO));
            } catch (Exception e) {
                //TODO log exception
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        //Activation
        @PostMapping("/signup/activation")
        public void signUpActivation(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
           signupService.activate(signupActivationDTO);
        }

        //Login
        @PostMapping("/login")
            public LoginRTO login(@RequestBody LoginDTO loginDTO) throws Exception{
                LoginRTO loginRto = loginService.login(loginDTO);
                if(loginRto == null) throw new Exception("Cannot login");
                return loginRto;
        }


        @PostMapping("/password/request")
        public ResponseEntity passwordRequest(@RequestBody RequestPasswordDTO requestPasswordDTO) throws Exception {
            try {
                passwordService.request(requestPasswordDTO);
               return ResponseEntity.ok().body("Abbiamo inviato un codice all'email inserita!");
            } catch (Exception e) {
                return ResponseEntity.ok().body("Abbiamo inviato un codice all'email inserita!");//NON INSERISCO NULLA PER PROTEGGERE GLI UTENTI DA ATTACCHI HACK
            }
        }

       @PostMapping("/password/restore")
        public void passwordRestore(@RequestBody RestorePasswordDTO restorePasswordDTO) throws Exception {
           try {
               passwordService.restore(restorePasswordDTO);
           } catch (Exception e) {
                //NON INSERISCO NULLA PER PROTEGGERE GLI UTENTI DA ATTACCHI HACK
           }
       }


}
