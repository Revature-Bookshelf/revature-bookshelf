package com.revature.revaturebookshelfjava.repository;



import com.revature.revaturebookshelfjava.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;


@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
