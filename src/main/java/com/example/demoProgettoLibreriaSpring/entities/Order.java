package com.example.demoProgettoLibreriaSpring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
@Getter
@Setter
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String clientSurname;

    @Column(unique = true, nullable = false)
    private String clientEmail;

    @Column(nullable = false)
    private String clientNumber;

    @ManyToMany
    private List<Book> books;

    @ManyToOne
    private Warehouse warehouse;

    public Order(String clientName, String clientSurname, String clientEmail, String clientNumber) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
        this.clientNumber = clientNumber;
    }

    public void addBook(Book book) {
        books.add( book);
    }

    public void removeBook(Book book) {
        // TODO approfondire il funzionamento di questo metodo
        books.remove(book);
    }

}
