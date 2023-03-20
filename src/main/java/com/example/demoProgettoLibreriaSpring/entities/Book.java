package com.example.demoProgettoLibreriaSpring.entities;

import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Autowired
    private BookRepository bookRepository;

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
