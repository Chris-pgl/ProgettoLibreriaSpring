package com.example.demoProgettoLibreriaSpring.entities;

import javax.persistence.*;
import lombok.*;



@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recepit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String shopName;
    private String info;
    private String address;
    private String telNumber;
    private String date;
    private String description;
    private double price;
    private String iva;
    private double total;
    private double cashPayment;
    private double electronicPayment;
    private double change;//resto
    private String numFiscalDocuments;

}
