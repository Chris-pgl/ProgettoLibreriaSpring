package com.example.demoProgettoLibreriaSpring.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String ISBN;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int copies;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Author author;
}
