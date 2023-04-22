package com.example.demoProgettoLibreriaSpring.entities;

import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
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

    @Column
    private String bio;

    @Column(nullable = false)
    private String placeOfBirth;

    /*
    Problemi a usare String per salvare una data:
    - ci troveremo con date scritte in modo diverso nel db (es. "12-4-1999", "1999/04/12", "12-apr-1999", ecc)
    - non possiamo fare operazioni sulle date (es. sapere quanti giorni sono passati da una data,
      oppure estrarre l'anno da una data)
     */
    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;


    /*

    One to Many significa:
    ogni libro ha UN SOLO autore, e ogni autore ha TANTI libri

    book -- one --> author    -> ogni libro ha un autore
    author -- many --> books  -> ogni autore ha una lista di libri

    Io sono un libro. Sono uno solo per ogni libro, ma ho molti libri -> one author to many books.

     */

    @OneToMany
    @JsonIgnore
    private List<Book> book;
}
