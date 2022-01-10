package com.revature.revaturebookshelfjava.service;

import com.revature.revaturebookshelfjava.entity.Book;
import com.revature.revaturebookshelfjava.entity.Cart;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.exception.CartItemNotExistException;

import java.util.List;

public interface CartService {

    Cart addItem(Book bookId);

    Cart deleteItem(int bookId) throws CartItemNotExistException;

    Cart updateItem(Book bookId);

    List<Book> getAllItems(User userId);

}
