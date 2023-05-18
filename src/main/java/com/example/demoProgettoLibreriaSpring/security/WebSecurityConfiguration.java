package com.example.demoProgettoLibreriaSpring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity( // https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    // in questo caso non usiamo @Configuration perché viene esteso da WebCOnfigureAdapter


    // con Bean l'oggetto viene preso e ci pensa spring.
    // Spring ora possiede questo Bean e il suo BCryptPasswordEncoder
    // se voglio usarlo basta fare un Autowired
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //il metodo configure decide chi entra, autentifica e guarda i documenti necessari
    public void configure (HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //tutti i percorsi auth devono essere liberi perché non posso essere autenticato se non sono registrato/loggato
        http.authorizeHttpRequests().antMatchers("/auth/**").permitAll()
        //per qualsiasi altra richiesta devo essere autenticato
                .anyRequest().authenticated();

        //csrf(Cross-Site Request Forgery) è una protezzione anti hack
        //Se vuoi accedere a questa Api deve avere un certificato rilasciato dallo stato
        //ex google meet ha una certificazione /Issued By GTS CA 1C3 che appartiene a google
       // in questo caso lo disabilitiamo perché si pagano i certificati e ora non ne abbiamo bisogno
        http.csrf().disable();
        //googlare per saperne di più
        http.headers().frameOptions().disable();

        //TODO implementare jwt token filter

    }
}
