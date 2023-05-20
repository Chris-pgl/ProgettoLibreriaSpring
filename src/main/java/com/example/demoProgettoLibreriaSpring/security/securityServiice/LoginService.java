package com.example.demoProgettoLibreriaSpring.security.securityServiice;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.LoginDTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.LoginRTO;
import com.example.demoProgettoLibreriaSpring.security.securityEntity.User;
import com.example.demoProgettoLibreriaSpring.security.securityRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginService {

    //TODO questo va nello .yml
    public static final String JWT_SECRET = "e8c368a1-18ce-4616-83ec-cbf535bc177e";

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;


    public LoginRTO login(LoginDTO loginDTO){
        //controllo se esiste
        if (loginDTO == null) return null;
        User userFromDB = userRepository.findByEmail(loginDTO.getEmail());
        if (userFromDB == null || !userFromDB.isActive()) return null;
        //controllo se può loggare
        boolean canLogin = canUserLogin(userFromDB, loginDTO.getPassword());
        //se non può loggare
        if (!canLogin)return null;

        String JWT = getJWT(userFromDB);

        userFromDB.setJwtCreateOn(LocalDateTime.now());
        userRepository.save(userFromDB);

        userFromDB.setPassword(null);
        LoginRTO out = new LoginRTO();
        out.setJWT(JWT);
        out.setUser(userFromDB);

        return out;
    }

    public boolean canUserLogin(User user, String password){
        return encoder.matches(password, user.getPassword());
    }

    public static String getJWT(User user) {
       return JWT.create().withClaim("id", user.getId()).sign(Algorithm.HMAC512(JWT_SECRET));
    }

}
