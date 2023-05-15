package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.DTO.BookDTO;
import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    }

    public Book saveBook(BookDTO bookDTO) throws Exception {
        try {
            Book book = new Book();
            book.setTitle(bookDTO.getTitle());
            book.setPrice(bookDTO.getPrice());
            book.setCopies(bookDTO.getCopies());
            book.setISBN(bookDTO.getISBN());
            book.setCreationDate(LocalDateTime.now());
            book.setAuthor(authorRepository.findById(bookDTO.getAuthorId()).get());
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new Exception("I could not create the Book, check if everything is alright!");
        }
    }

    public Book deleteBook(long id){
        bookRepository.deleteById(id);
        return null;
    }

    public Book updateBook(long id, BookDTO bookDTO) throws Exception {
        try {
            Book bookToBeUpdated = bookRepository.findById(id).get();

            bookToBeUpdated.setTitle(bookDTO.getTitle());
            bookToBeUpdated.setPrice(bookDTO.getPrice());
            bookToBeUpdated.setCopies(bookDTO.getCopies());
            bookToBeUpdated.setISBN(bookDTO.getISBN());

            return bookRepository.save(bookToBeUpdated);

        } catch (Exception e) {
            throw new Exception("Cannot find Book with ID : "+id);
        }
    }

}
