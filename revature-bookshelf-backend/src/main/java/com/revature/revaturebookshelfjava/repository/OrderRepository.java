package com.revature.revaturebookshelfjava.repository;


import com.revature.revaturebookshelfjava.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order,Integer> {
//    Optional<Order> findByCartUserId(String userId);
}
