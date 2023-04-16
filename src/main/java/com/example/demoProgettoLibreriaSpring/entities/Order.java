package com.example.demoProgettoLibreriaSpring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String clientSurname;

    @Column(nullable = false)
    private String clientEmail;

    @Column(nullable = false)
    private String clientNumber;

    @OneToMany
    private List<Book> book;

    @ManyToOne
    private Warehouse warehouse;
}
