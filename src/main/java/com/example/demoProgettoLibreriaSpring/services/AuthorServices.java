package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Author;
import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
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
public class AuthorServices {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Author> getAuthorById(long id){
        return authorRepository.getById(id);
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(long id){
        authorRepository.deleteById(id);
    }
}
