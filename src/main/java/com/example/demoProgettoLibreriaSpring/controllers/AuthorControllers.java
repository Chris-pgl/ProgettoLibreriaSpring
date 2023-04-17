package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Author;

import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import com.example.demoProgettoLibreriaSpring.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors")
public class AuthorControllers {

    // todo ResponseEntity              done
    // todo gestione eccezioni          doing
    // todo metodi update               done

    @Autowired
    private AuthorServices authorServices;

    @GetMapping("/all")
    public List<Author> getAuthorsList() {
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
    public ResponseEntity<String> saveAuthor(@RequestBody Author author) {
        //authorServices.saveAuthor(author);
        try {
            authorServices.saveAuthor(author);
            return ResponseEntity.ok().body("Author created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error.. " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public void deleteAuthorById(@RequestParam long id) {
        authorServices.deleteAuthor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAuthor(@PathVariable long id, @RequestBody Author author) {
        try {
            return ResponseEntity.ok("Update Complite :" + authorServices.updateAuthor(id, author));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}


