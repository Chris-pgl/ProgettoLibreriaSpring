package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Author;
import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Author getAuthorById(long id) throws Exception {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()){
            return optionalAuthor.get();
        }else throw new Exception("Author with id " + id + " does not exist");
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(long id){
        authorRepository.deleteById(id);
    }
}
