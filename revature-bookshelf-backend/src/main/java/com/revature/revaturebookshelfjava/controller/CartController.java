package com.revature.revaturebookshelfjava.controller;

import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/cart")
public class CartController {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private CartRepository cartRepository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/{userId}")
    public Cart viewCartByUserId(@PathVariable String userId){
        Optional<Cart> optCart=cartRepository.findByUserId(userId);
        if(optCart.isEmpty()){
            Cart cart = new Cart();
            cart.setUserId(userId);
//            cart = cartRepository.findByUserId(userId).stream().findFirst().get();
            log.info("inside viewCartByUserId in controller because cart dont exist for that user");
            return cartRepository.save(cart);
        } else{
//            Cart crt=
            log.info("inside viewCartByUserId in controller");
            return optCart.stream().findFirst().get();
        }
    }

    @PostMapping("/add")
    public Cart addCart(@RequestBody Cart cart){
        log.info("inside add cart");
        return cartRepository.save(cart);
    }

    @PutMapping("/empty")
    public Cart emptyCart(@RequestBody Cart cart){
        Cart temp = new Cart();
        temp = cart;
        cartRepository.delete(cart);
        temp.getBooks().clear();
        return cartRepository.save(temp);
    }

//    public ShopBook getBookDetails(int bookId){
//        return restTemplate.getForObject("",ShopBook.class);
//    }
}
