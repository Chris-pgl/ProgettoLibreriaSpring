package com.example.demoProgettoLibreriaSpring.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recepit {

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
