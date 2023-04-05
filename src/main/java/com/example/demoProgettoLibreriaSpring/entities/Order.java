package com.example.demoProgettoLibreriaSpring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String bookTitle;

    private String bookISBN;

    private double bookPrice;

    private String clientName;

    private String clientSurname;

    private String clientEmail;


}
