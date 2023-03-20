package com.example.demoProgettoLibreriaSpring.repositories;

import com.example.demoProgettoLibreriaSpring.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Long> {

}
