package com.revature.revaturebookshelfjava.repository;

import com.revature.revaturebookshelfjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
