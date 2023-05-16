package com.example.demoProgettoLibreriaSpring.repositories;

import com.example.demoProgettoLibreriaSpring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByTitleIgnoreCase(String title);

  //  void sellBook(long bookid);
}
