package com.example.demoProgettoLibreriaSpring.entities;

import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {


    //private AuthorRepository authorRepository;

    /*
    potremmo volere separare nome e cognome, poi potremmo mettere data di nascita, genere, bio, ecc
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String name;

    /*

    One to Many significa:
    ogni libro ha UN SOLO autore, e ogni autore ha TANTI libri

    book -- one --> author    -> ogni libro ha un autore
    author -- many --> books  -> ogni autore ha una lista di libri

    Io sono un libro. Sono uno solo per ogni libro, ma ho molti libri -> one author to many books.

     */

    @OneToMany
    private List<Book> book;
}
