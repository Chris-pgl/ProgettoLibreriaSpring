package com.example.demoProgettoLibreriaSpring.entities;


import lombok.*;

import javax.persistence.*;

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

    @OneToMany
    private Book book;
}
