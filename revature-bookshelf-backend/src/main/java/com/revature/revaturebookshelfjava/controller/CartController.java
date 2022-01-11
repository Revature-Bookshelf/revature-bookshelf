package com.revature.revaturebookshelfjava.controller;


import com.revature.revaturebookshelfjava.entity.Book;
import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.exception.CartItemNotExistException;
import com.revature.revaturebookshelfjava.repository.CartRepository;
import com.revature.revaturebookshelfjava.repository.UserRepository;
import com.revature.revaturebookshelfjava.service.CartService;
import com.revature.revaturebookshelfjava.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;

@RequestMapping("/api/cart")
@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@Slf4j
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping("/view")
    public List<Book> getCart() {
        String username = extractUsername();
        User user = userService.getUser(username);
        return cartService.getAllItems(user);
    }

    @PostMapping("/add/{bookId}")
    public ResponseEntity<?> postItem(@PathVariable(name = "bookId") int bookId) {
        String username = extractUsername();
        User user = userService.getUser(username);
        cartService.addItem(bookId, user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book item #" + bookId + " successfully added");
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<?> deleteItem(@PathVariable(name = "bookId") int bookId) {
        String username = extractUsername();
        User user = userService.getUser(username);

        try {
            cartService.deleteItem(bookId, user);
            return ResponseEntity.ok().body("Book item #" + bookId + " successfully deleted");
        } catch (CartItemNotExistException e) {
            return ResponseEntity.badRequest().body("CartItemNotExistException");
        }
    }

    /*
    @PutMapping("/update{bookId}")
    public ResponseEntity<?> updateItem(@PathVariable(name = "bookId") int id, @RequestBody Book bookId){
        Book book = bookRepository.getById(cartRepository.getById(id));
        return ResponseEntity.ok(Book);
    }
     */
    public String extractUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
