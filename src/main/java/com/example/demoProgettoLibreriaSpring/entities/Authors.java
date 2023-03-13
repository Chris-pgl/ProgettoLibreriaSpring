package com.example.demoProgettoLibreriaSpring.entities;

public class Authors {
    private String name;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Authors(String name, long id) {
        this.name = name;
        this.id = id;
    }
    public Authors(){};
}
