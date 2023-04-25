package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Author;
import com.example.demoProgettoLibreriaSpring.repositories.AuthorRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Author updateAuthor(@PathVariable long id, @RequestBody Author author) throws Exception {
        Author updateAuthor = authorRepository.getAuthorById(id);
        try {
            updateAuthor.setName(author.getName());
            updateAuthor.setBio(author.getBio());
            updateAuthor.setBook(author.getBook());
            updateAuthor.setPlaceOfBirth(author.getPlaceOfBirth());
            updateAuthor.setDateOfBirth(author.getDateOfBirth());

            authorRepository.save(updateAuthor);
            return updateAuthor;
        } catch (Exception e) {
            throw new Exception("Not Update " + e.getMessage());
        }
    }

}
