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

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;

    /*
    //@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    // TODO Giusto cosi sistemarlo in tutto
     */

    @OneToMany
    @JsonIgnore
    private List<Book> book;
}
