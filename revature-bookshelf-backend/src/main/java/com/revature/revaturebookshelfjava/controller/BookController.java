package com.revature.revaturebookshelfjava.controller;

import com.revature.revaturebookshelfjava.entity.Book;
import com.revature.revaturebookshelfjava.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.web.bind.annotation.*;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {


    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks() {
        return bookRepository.findAllAvailable();
    }

    @GetMapping("/books/{_genre}")
    public List<Book> getSelectGenre(@PathVariable String _genre) {
        return bookRepository.findSelectGenre(_genre);
    }

    @GetMapping("/genres")
    public List<String> getAllGenres() {
        List<String> genres = new ArrayList<>();
        List<String> allGenres = new ArrayList<>();

        for(int i=0; i<bookRepository.findAllGenres().size(); i++){
            genres.add(i,bookRepository.findAllGenres().get(i));
        }

        for(int i=0; i<genres.size(); i++){
            allGenres.add(genres.get(i).substring(11,genres.get(i).lastIndexOf("}")-1));
        }

        return allGenres.stream().distinct().collect(Collectors.toList());

    }


}
