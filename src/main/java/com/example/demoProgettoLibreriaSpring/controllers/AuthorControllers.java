package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Author;

import com.example.demoProgettoLibreriaSpring.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors")
public class AuthorControllers {

    // todo ResponseEntity
    // todo gestione eccezioni
    // todo metodi update

    @Autowired
    private AuthorServices authorServices;

    @GetMapping("/all")
    public List<Author> getAuthorsList(){
        return authorServices.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAuthorById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(authorServices.getAuthorById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public void saveAuthor(@RequestBody Author author){
        authorServices.saveAuthor(author);
    }

    @DeleteMapping("/delete")
    public void deleteAuthorById(@RequestParam long id){
        authorServices.deleteAuthor(id);
    }
}
