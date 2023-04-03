package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.entities.BookDTO;
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


    /*
    Azione: inserire un nuovo libro (es il signore degli anelli)

    POST /save
    {
        "title": "il signore degli anelli: la compagnia dell'anello",
        "isbn": "bhf678fveajbhf",
        "price": "17.99",
        "author": {
            "id": "123",
            "name": "John Ronald Ruel",
            "surname": "Tolkien",
            "dateOfBirth": "1897-03-12",
            "placeOfBirth": "London"
        }
    }

     {
        "title": "il signore degli anelli: la compagnia dell'anello",
        "isbn": "bhf678fveajbhf",
        "price": "17.99",
        "authorId": "123"
    }

     */

    /*
    Questa funzione, oltre che salvare un libro nel database, deve anche associare l'autore al libro.
    Nella richiesta c'è scritto chi è l'autore -> qual è il suo id
    Noi dobbiamo estrarre l'autore con l'id indicato nella richiesta e inserirlo dentro al libro.
     */
    @PostMapping("/save")
    public void saveBook(@RequestBody BookDTO bookDTO){
        bookServices.saveBook(bookDTO);
    }

    @DeleteMapping("/delete")
    public void deleteBookById(@RequestParam long id){
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
