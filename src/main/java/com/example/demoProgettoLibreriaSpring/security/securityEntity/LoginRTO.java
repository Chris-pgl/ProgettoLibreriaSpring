package com.example.demoProgettoLibreriaSpring.security.securityEntity;

import lombok.Data;

@Data
public class LoginRTO {

    private User user;
    String JWT;
}
