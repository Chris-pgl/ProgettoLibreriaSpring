package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Author;

import com.example.demoProgettoLibreriaSpring.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
@RequestMapping("/authors")
public class AuthorControllers {

        @Autowired
        private AuthorServices authorServices;

        @GetMapping("/all")
        public List<Author> getAuthorsList(){
            return authorServices.getAllAuthors();
        }

        @GetMapping("/{id}")
        public Author getAuthorById(@PathVariable long id) throws Exception {
            return authorServices.getAuthorById(id);
        }

        @PostMapping("/save")
        public void saveAuthor(Author author){
            authorServices.saveAuthor(author);
        }

        @DeleteMapping("/delete")
        public void deleteAuthorById(long id){
            authorServices.deleteAuthor(id);
        }
}
