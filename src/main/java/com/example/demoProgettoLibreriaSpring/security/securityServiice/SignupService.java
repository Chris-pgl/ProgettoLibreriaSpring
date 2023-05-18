package com.example.demoProgettoLibreriaSpring.security.securityServiice;

import com.example.demoProgettoLibreriaSpring.security.securityEntity.SignupDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.User;
import com.example.demoProgettoLibreriaSpring.security.securityRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User signup(SignupDTO signupDTO) throws Exception {
        //controlliamo prima della creazione se esiste l'username o email
        if (userRepository.existsByUsername(signupDTO.getUsername())) throw  new Exception("Username "+ signupDTO.getUsername() +" is already exists");
        if (userRepository.existsByEmail(signupDTO.getEmail())) throw  new Exception("Email "+ signupDTO.getEmail() + " is already exists");
        User user = new User(
                signupDTO.getName(),
                signupDTO.getSurname(),
                signupDTO.getUsername(),
                encoder.encode(signupDTO.getPassword()), //con encoder criptiamo la password
                signupDTO.getEmail());

        user.setActivationCode(UUID.randomUUID().toString());

        return userRepository.save(user);
    }


}
