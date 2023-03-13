package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.entities.Recepit;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping("/get-book-list")
    public List <Book> getBooksList(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter","2345d4",12.56, 7));
        bookList.add(new Book("Il signore degli anelli","JSHEH4455",12.30, 8));
        return bookList;
    }

    @GetMapping("/books-price")
    public Recepit sellBooks(){
        //scalare il numero totale di copie dal magazino,
        //creare uno scontrino e restituirlo
        //aggiornare il totale in cassa
        return null;
    }



}
