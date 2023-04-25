package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.DTO.BookDTO;
import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBookByTitle(String title) throws Exception {

        List<Book> books = bookRepository.findByTitleIgnoreCase(title);
        if (books.size() == 0) {
            throw new Exception("Cannot find any book with title: " + title);
        }
        return books;

        //bookRepository.findByTitle(title);
        // Momentaneamente non funziona è da problemi

    }

    public Book saveBook(BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setCopies(bookDTO.getCopies());
        book.setISBN(bookDTO.getISBN());
        book.setCreationDate(LocalDateTime.now());
        book.setAuthor(authorRepository.findById(bookDTO.getAuthorId()).get());
        return bookRepository.save(book);
    }

    public Book deleteBook(long id){
        bookRepository.deleteById(id);
        return null;
    }

}
