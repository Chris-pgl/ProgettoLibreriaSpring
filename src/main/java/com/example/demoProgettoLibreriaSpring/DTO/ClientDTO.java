package com.example.demoProgettoLibreriaSpring.DTO;

public class ClientDTO {

    private String name;

    private String username;

    private String cellNumber;

    private String email;


    public ClientDTO() {
    }

    public String getName() {
        return name;
    }

    public String setName() {
       return name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
