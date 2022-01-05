package com.revature.revaturebookshelfjava.repository;


import com.revature.revaturebookshelfjava.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart,Integer> {
    Optional<Cart> findByUserId(String userId);
}