package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.entities.Recepit;
import com.example.demoProgettoLibreriaSpring.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookControllers {

    @Autowired
    private BookServices bookServices;

    @GetMapping("/all")
    public List <Book> getBooksList() {
        return bookServices.getAllBooks();
    }

    @GetMapping("/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookServices.getBookByTitle(title);
    }

    @PostMapping("/save")
    public void saveBook(Book book){
        bookServices.saveBook(book);
    }

    @DeleteMapping("/delete")
    public void deleteBookById(long id){
        bookServices.deleteBook(id);
    }

    @GetMapping("/books-price")
    public Recepit sellBooks(){
        //scalare il numero totale di copie dal magazino,
        //creare uno scontrino e restituirlo
        //aggiornare il totale in cassa
        return null;
    }



}
