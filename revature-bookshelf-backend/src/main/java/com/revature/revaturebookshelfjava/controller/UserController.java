package com.revature.revaturebookshelfjava.controller;

import com.revature.revaturebookshelfjava.controller.payload.HttpResponseBody;
import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.service.CartService;
import com.revature.revaturebookshelfjava.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
