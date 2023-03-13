package com.example.demoProgettoLibreriaSpring.entities;

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

    Recepit(){};

    public Recepit(String shopName, String info, String address, String telNumber, String date, String description, double price, String iva, double total, double cashPayment, double electronicPayment, double change, String numFiscalDocuments) {
        this.shopName = shopName;
        this.info = info;
        this.address = address;
        this.telNumber = telNumber;
        this.date = date;
        this.description = description;
        this.price = price;
        this.iva = iva;
        this.total = total;
        this.cashPayment = cashPayment;
        this.electronicPayment = electronicPayment;
        this.change = change;
        this.numFiscalDocuments = numFiscalDocuments;
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
