package com.example.demoProgettoLibreriaSpring.entities;

public class Book {

    private String title;

    private String ISBN;

    private double price;


    private int copies;

    public Book(){

    }

    public Book(String title, String ISBN, double price, int copies) {
        this.title = title;
        this.ISBN = ISBN;
        this.price = price;
        this.copies = copies;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCopie() {
        return copies;
    }

    public void setCopie(int copie) {
        this.copies = copie;
    }

}
