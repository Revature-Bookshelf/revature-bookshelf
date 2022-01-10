package com.revature.revaturebookshelfjava.service;

import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    //UserDetails loadUserByUsername(String username);
    void register(User user, Cart cart);
    User getUser(String username);
}
