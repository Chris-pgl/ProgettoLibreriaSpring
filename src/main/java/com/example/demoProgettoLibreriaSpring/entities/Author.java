package com.example.demoProgettoLibreriaSpring.entities;

import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {


    //private AuthorRepository authorRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String name;

    @OneToMany
    private Book book;
}
