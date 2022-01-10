package com.revature.revaturebookshelfjava.service;

import com.revature.revaturebookshelfjava.entity.Book;
import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.exception.CartItemNotExistException;
import com.revature.revaturebookshelfjava.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addItem(Book bookId) {
        Cart cart = addItem(bookId);
        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteItem(int bookId) throws CartItemNotExistException {
        Cart cart = deleteItem(bookId);
        if(!cartRepository.existsById(bookId))
            throw new CartItemNotExistException("book id is invalid :" + bookId);
        cartRepository.deleteById(bookId);
        return cart;
    }

    @Override
    public Cart updateItem(Book bookId) {
        Cart cart = updateItem(bookId);
        return cartRepository.save(cart);
    }

    @Override
    public List<Book> getAllItems(User userId) {
        return null;
    }
}
