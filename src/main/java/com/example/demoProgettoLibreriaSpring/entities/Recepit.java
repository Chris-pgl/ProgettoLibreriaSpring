package com.example.demoProgettoLibreriaSpring.entities;

import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "recepit")

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

    public Recepit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(double cashPayment) {
        this.cashPayment = cashPayment;
    }

    public double getElectronicPayment() {
        return electronicPayment;
    }

    public void setElectronicPayment(double electronicPayment) {
        this.electronicPayment = electronicPayment;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getNumFiscalDocuments() {
        return numFiscalDocuments;
    }

    public void setNumFiscalDocuments(String numFiscalDocuments) {
        this.numFiscalDocuments = numFiscalDocuments;
    }
}
