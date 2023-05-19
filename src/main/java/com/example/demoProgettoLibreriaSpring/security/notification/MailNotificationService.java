package com.example.demoProgettoLibreriaSpring.security.notification;

import com.example.demoProgettoLibreriaSpring.security.securityEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendActivationEmail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("email4testDeveloper@gmail.com");
        sms.setReplyTo("email4testDeveloper@gmail.com");
        sms.setSubject("Benvenuto su DevelBooks!");
        sms.setText(
                "Ciao! "+ user.getUsername()+" Benvenuto su DevelBooks La tua libreria automatica."
               + "\nIl tuo codice di attivazione è: " + user.getActivationCode()); // per ora manteniamo in questo modo
      //sms.setText(" Clicca qui per attivare il tuo account https://www.mioSito.it/signup/activation " + user.getActivationCode()); Così sarà in produzione
        emailSender.send(sms);
    }
}
