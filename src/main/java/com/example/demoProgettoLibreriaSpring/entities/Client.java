package com.example.demoProgettoLibreriaSpring.entities;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)

    private String name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true)
    private String cellNumber;


    /*
    piu avanti ci sarà un
    @OneToMany
    private Order order;
     */




}
