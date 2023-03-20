package com.example.demoProgettoLibreriaSpring.entities;


import com.example.demoProgettoLibreriaSpring.repositories.WarehouseRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

    @Column(nullable = false)
   private String place;

    @OneToMany
    private Book book;
}
