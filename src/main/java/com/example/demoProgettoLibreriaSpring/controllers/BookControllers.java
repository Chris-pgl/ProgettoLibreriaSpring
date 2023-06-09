package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.DTO.BookDTO;
import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import com.example.demoProgettoLibreriaSpring.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookControllers {

    @Autowired
    private BookServices bookServices;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/all")
    public List <Book> getBooksList() {
        return bookServices.getAllBooks();
    }

    @GetMapping("/find-by-title")
    public ResponseEntity getBookByTitle(@RequestParam String title){
        try {
            // se troviamo un solo libro restituiamo una RE con dentro il libro
            // se ne troviamo tanti la restituiamo con dentro una lista
            List<Book> books = bookServices.getBookByTitle(title);
            if (books.size() == 1) {
                return ResponseEntity.ok(books.get(0));
            }
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/findByISBN")
    public ResponseEntity getBookByISBN(@RequestParam String ISBN) throws Exception {
        try {
            List<Book> book = bookServices.getBookByISBN(ISBN);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
    public ResponseEntity saveBook(@RequestBody BookDTO bookDTO) throws Exception {
        bookServices.saveBook(bookDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public void deleteBookById(@RequestParam long id){
        bookServices.deleteBook(id);
    }

//    @GetMapping("/book-price")
//    public Recepit sellBooks(){
//        //scalare il numero totale di copie dal magazino,
//        //creare uno scontrino e restituirlo
//        return null;
//    }

    // localhost:8080/books/update/15
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable long id, @RequestBody BookDTO bookDetail ){
        try {
            Book b = bookServices.updateBook(id, bookDetail);
            return ResponseEntity.ok(b);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
