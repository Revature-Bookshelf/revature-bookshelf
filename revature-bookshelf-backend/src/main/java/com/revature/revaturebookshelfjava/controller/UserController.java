package com.revature.revaturebookshelfjava.controller;


import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.Collection;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository=userRepository;
    }


    @GetMapping(value="/api/profile")
    public Collection<User> getAll(){
        return userRepository.findAll();}

    @GetMapping(value="/api/profile/{userId}",
            produces="application/json")
    public ResponseEntity<?> get (@PathVariable(name="userId") int userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalUser.get());
    }




    @PostMapping(value="/api/edit-profile")
    public ResponseEntity<?> post(@RequestBody User user){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        userRepository.findByEmail(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(value="/api/edit-profile/{userId}",
            consumes ="application/json")
    public ResponseEntity<?> put(@PathVariable String userId, @RequestBody User user){
        user.setId(userId);
        user= userRepository.save(user); //updates user
        return ResponseEntity.ok(user);
    }
    @DeleteMapping(value="/api/edit-profile/{userId}")
    public ResponseEntity<?>delete(@PathVariable int userId){
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }

}
