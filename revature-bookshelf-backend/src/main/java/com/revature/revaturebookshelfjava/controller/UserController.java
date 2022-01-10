package com.revature.revaturebookshelfjava.controller;

import com.revature.revaturebookshelfjava.controller.payload.HttpResponseBody;
import com.revature.revaturebookshelfjava.entity.User;
<<<<<<< HEAD
import com.revature.revaturebookshelfjava.service.UserService;
=======
>>>>>>> main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

<<<<<<< HEAD
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
=======
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
>>>>>>> main
    }

    // TODO: Finalize URL
    // POST /api/users
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/users"
    )
    public ResponseEntity<?> doRegistration(@RequestBody User user) {

        userService.register(user);

        HttpResponseBody responseBody = new HttpResponseBody("user registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);

    }

<<<<<<< HEAD
=======
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
>>>>>>> main

}
