package com.example.demoProgettoLibreriaSpring.security.securityServiice;

import com.example.demoProgettoLibreriaSpring.security.securityEntity.LoginDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.LoginRTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.User;
import com.example.demoProgettoLibreriaSpring.security.securityRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public LoginRTO login(LoginDTO loginDTO){
        //controllo se esiste
        if (loginDTO == null) return null;
        User userFromDB = userRepository.findByEmail(loginDTO.getEmail());
        if (userFromDB == null || !userFromDB.isActive()) return null;
        //controllo se può loggare
        boolean canLogin = this.canUserLogin(userFromDB, loginDTO.getPassword());
        //se non può loggare
        if (!canLogin)return null;

        String JWT = getJWT(userFromDB);

        userFromDB.setJwtCreateOn(LocalDateTime.now());
        userRepository.save(userFromDB);

        LoginRTO out = new LoginRTO();
        out.setJWT(JWT);
        out.setUser(userFromDB);

        return out;
    }

    public static boolean canUserLogin(User user, String password){
        return user.getPassword().equals(password);
    }

    public static String getJWT(User user){
        return "--------------------";
    }

}
