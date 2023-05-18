package com.example.demoProgettoLibreriaSpring.entities;


import com.example.demoProgettoLibreriaSpring.repositories.WarehouseRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@Entity
@Table(name = "werehouse")
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

    // questa relazione si potrebbe anche rimuovere, perché è implicita nell'inventario
    @OneToMany
    @JsonIgnore
    private List<Book> book;

    @OneToMany
    @JsonIgnore
    private List<Order> order;
}
