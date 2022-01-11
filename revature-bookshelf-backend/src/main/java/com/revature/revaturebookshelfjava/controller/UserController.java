package com.revature.revaturebookshelfjava.controller;

import com.revature.revaturebookshelfjava.controller.payload.HttpResponseBody;
import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.service.CartService;
import com.revature.revaturebookshelfjava.service.UserService;

import nonapi.io.github.classgraph.json.JSONDeserializer;
import nonapi.io.github.classgraph.json.JSONSerializer;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    private CartService cartService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO: Finalize URL
    // POST /api/users
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/users"
    )
    public SecureUser getUser() {
        String username = extractUsername();
        // Note: some circular mapping of entities of cart and user in foundUser
        User foundUser = userService.getUser(username);

        // Using Inner Private Class to Encapsulate sensitive information
        SecureUser securedUser = new SecureUser();
        securedUser.id = foundUser.getId();
        securedUser.email = foundUser.getEmail();
        securedUser.firstName = foundUser.getFirstName();
        securedUser.middleName = foundUser.getMiddleName();
        securedUser.lastName = foundUser.getLastName();

        return securedUser;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/users"
    )
    public ResponseEntity<?> doRegistration(@RequestBody User user) {
        Cart newCart = cartService.createCart(new Cart());
        user.setCart(newCart);
        User savedUser = userService.register(user);

        HttpResponseBody responseBody = new HttpResponseBody("user registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    public String extractUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    private class SecureUser{
        public int id;
        public String email;
        public String firstName;
        public String middleName;
        public String lastName;
    }
}
