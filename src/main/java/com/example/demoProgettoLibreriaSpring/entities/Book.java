package com.example.demoProgettoLibreriaSpring.entities;

import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;



@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    // perché stiamo importanto bookRepository in questa classe? a cosa ci serve?
    // @Autowired
    // private BookRepository bookRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true)
    private String ISBN;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int copies;

    @ManyToOne
    private Warehouse warehouse;

    /*
    Io sono un libro. Noi libri siamo molti per ogni autore -> many books to one author.
     */
    @ManyToOne
    private Author author;
}
