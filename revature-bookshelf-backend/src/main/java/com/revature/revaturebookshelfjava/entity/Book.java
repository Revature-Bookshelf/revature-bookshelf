package com.revature.revaturebookshelfjava.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    private int id;
    private String title;
    private int pageCount;
    private String isbn;
    private String author;
    private String genre;
    private String imgPath;
    private int quantity;
    private double price;

}
