package com.example.demoProgettoLibreriaSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "books")
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

    @Column(unique = true, nullable = false)
    private String ISBN;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int copies;

    private LocalDateTime creationDate;


    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Author author;

    @ManyToMany
    @JsonIgnore
    private List<Order> order;
}
