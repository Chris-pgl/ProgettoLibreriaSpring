package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


    /*@Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List<Book> searchByTitleLike(@Param("title") String title);*/
    public List<Book> getBookByTitle(String title){
        return null;
        //TODO sistemare questo errore
        //bookRepository.findByTitle(title);
        // Momentaneamente non funziona è da problemi
    }

    public Book saveBook(Book book){
        bookRepository.save(book);
        return book;
    }

    public Book deleteBook(long id){
        bookRepository.deleteById(id);
        return null;
    }
}
