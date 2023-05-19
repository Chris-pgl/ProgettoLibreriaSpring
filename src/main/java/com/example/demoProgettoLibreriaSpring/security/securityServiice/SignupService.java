package com.example.demoProgettoLibreriaSpring.security.securityServiice;

import com.example.demoProgettoLibreriaSpring.security.notification.MailNotificationService;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.SignupActivationDTO;
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

    @Autowired
    private MailNotificationService mailNotificationService;

    public User signup(SignupDTO signupDTO) throws Exception {
        //controlliamo prima della creazione se esiste l'username o email
        if (userRepository.existsByUsername(signupDTO.getUsername())) throw  new Exception("Username "+ signupDTO.getUsername() +" is already exists");
        if (userRepository.existsByEmail(signupDTO.getEmail())) throw  new Exception("Email "+ signupDTO.getEmail() + " is already exists");
        User user = new User();
        user.setName(signupDTO.getName());
        user.setSurname(signupDTO.getSurname());
        user.setUsername(signupDTO.getUsername());
        user.setEmail(signupDTO.getEmail());

        user.setPassword(signupDTO.getPassword());
        //user.setPassword(encoder.encode(signupDTO.getPassword()));
        //TODO sistemare password encoder,decripta la password ma la salva in quel modo per accedere

        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());

        mailNotificationService.sendActivationEmail(user);

        return userRepository.save(user);
    }


    public User activate(SignupActivationDTO signupActivationDTO) throws Exception {
        User user = userRepository.getByActivationCode(signupActivationDTO.getActivationCode());
        if (user == null)throw new Exception("User not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.save(user);

    }
}
