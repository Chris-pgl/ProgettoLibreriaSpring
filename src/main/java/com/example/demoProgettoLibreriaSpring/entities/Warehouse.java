package com.example.demoProgettoLibreriaSpring.entities;

public class Warehouse {
   private long id;
   private String place;
   private long bookId;
   private int quantity;

   public Warehouse(){};
    public Warehouse(long id, String place, long bookId, int quantity) {
        this.id = id;
        this.place = place;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
