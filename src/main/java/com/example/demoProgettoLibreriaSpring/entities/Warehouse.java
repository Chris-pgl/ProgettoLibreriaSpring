package com.example.demoProgettoLibreriaSpring.entities;


import com.example.demoProgettoLibreriaSpring.repositories.WarehouseRepository;
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

    // @Autowired   questo serve solo nel service
    // private WarehouseRepository warehouseRepository;

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
    private List<Book> book;

    @OneToMany
    private List<Order> order;
}
