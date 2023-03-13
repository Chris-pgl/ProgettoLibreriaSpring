package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Authors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
    @RestController
@RequestMapping("/authors")
public class AuthorsController {



        @GetMapping("/get-authors-list")
        public List<Authors> getAuthorsList(){
            List<Authors> authorList = new ArrayList<>();
            authorList.add(new Authors("J.K. Rowling",1));
            authorList.add(new Authors("Stephen King",2));
            return authorList;
        }

}
