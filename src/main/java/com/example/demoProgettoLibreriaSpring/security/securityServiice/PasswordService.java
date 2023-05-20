package com.example.demoProgettoLibreriaSpring.security.securityServiice;

import com.example.demoProgettoLibreriaSpring.security.notification.MailNotificationService;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.RequestPasswordDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.RestorePasswordDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.User;
import com.example.demoProgettoLibreriaSpring.security.securityRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private MailNotificationService mailNotificationService;

    public User request(RequestPasswordDTO requestPasswordDTO) throws Exception {
      User userFromDB = userRepository.findByEmail(requestPasswordDTO.getEmail());
      if (userFromDB == null) throw new Exception("User is null..");
    //if (userFromDB == null || !userFromDB.isActive()) throw new Exception("Cannot find user");
    /*Ci sono due linee di pensiero su questa cosa.
        Possiamo scegliere di non dare la password a un user che non si è attivato
        o Attivarlo perché sta ricevendo l'email di reset password e implicitamente sta attivando.
        Abbiamo scelto la seconda.
        per non creare Diatriba sull'argomento
     */
      userFromDB.setPasswordResetCode(UUID.randomUUID().toString());

      mailNotificationService.sendPasswordResetMail(userFromDB);
      return userRepository.save(userFromDB);
    }
    //IN genere non vogliamo tornare gli user, per non rischiare complicazione come furto di password e utenti.
    //ma in questo servizio possiamo farlo..

    public User restore(RestorePasswordDTO restorePasswordDTO) throws Exception {
        User userFromDB = userRepository.findByPasswordResetCode(restorePasswordDTO.getResetPasswordCode());
        if (userFromDB == null) throw new Exception("User is null..");
        userFromDB.setPassword(encoder.encode(restorePasswordDTO.getNewPassword()));
        userFromDB.setPasswordResetCode(null);
        //Attivo l'utente perché sta cercamdo di riprendere la password-/NON è UN UTENTE FANTASMA
        userFromDB.setActive(true);
        userFromDB.setActivationCode(null);
        return userRepository.save(userFromDB); //questo utente ha una password Hashata, non dovremo portarlo sull'API
    }

}
