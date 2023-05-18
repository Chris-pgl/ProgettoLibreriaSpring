package com.example.demoProgettoLibreriaSpring.security.controller;

import com.example.demoProgettoLibreriaSpring.security.securityEntity.LoginDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.RequestPasswordDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.RestorePasswordDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.SignupDTO;
import com.example.demoProgettoLibreriaSpring.security.securityServiice.LoginService;
import com.example.demoProgettoLibreriaSpring.security.securityServiice.PasswordService;
import com.example.demoProgettoLibreriaSpring.security.securityServiice.SignupService;
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
        public ResponseEntity signUpActivation(@RequestBody  ){
            try{
                return null;
            }catch (Exception e){
                return null;
            }
        }

        //Login
        @PostMapping("/login")
        public ResponseEntity loginController(@RequestBody LoginDTO loginDTO){
            try{
                return ResponseEntity.ok(loginService.login(loginDTO));
            }catch (Exception e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/password/request")
        public void passwordRequest(@RequestBody RequestPasswordDTO requestPasswordDTO){
            passwordService.request(requestPasswordDTO);
        }

       @PostMapping("/password/restore")
        public void passwordRestore(@RequestBody RestorePasswordDTO restorePasswordDTO){
            passwordService.restore(restorePasswordDTO);
       }


}
