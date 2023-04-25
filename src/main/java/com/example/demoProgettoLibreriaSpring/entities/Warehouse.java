package com.example.demoProgettoLibreriaSpring.entities;


import com.example.demoProgettoLibreriaSpring.repositories.WarehouseRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String place;

    /*
    private Book book è sbagliato perchè significherebbe che nel magazzino c'è un libro solo
    invece ce ne sono tanti -> vogliamo una collezione (una lista, un set, una mappa...)
     */
    @OneToMany
    @JsonIgnore
    private List<Book> book;

    @OneToMany
    @JsonIgnore
    private List<Order> order;
}
