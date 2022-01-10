package com.revature.revaturebookshelfjava.controller;


import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/cart")
@CrossOrigin(origins={"http://localhost:4200/"})
@RestController
@Slf4j
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/view")
    public Collection<Cart> getAll(){
        return cartRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody Cart bookId){
        cartRepository.save(bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
    }

    @DeleteMapping("/delete{bookId}")
    public ResponseEntity<?> deleteItem(@PathVariable(name = "bookId") int bookId) {
        cartRepository.deleteById(bookId);
        return ResponseEntity.ok().build();
    }

    /*
    @PutMapping("/update{bookId}")
    public ResponseEntity<?> updateItem(@PathVariable(name = "bookId") int id, @RequestBody Book bookId){
        Book book = bookRepository.getById(cartRepository.getById(id));
        return ResponseEntity.ok(Book);
    }
     */
}
