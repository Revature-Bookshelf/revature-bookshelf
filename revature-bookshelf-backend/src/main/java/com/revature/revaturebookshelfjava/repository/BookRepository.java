package com.revature.revaturebookshelfjava.repository;


import com.revature.revaturebookshelfjava.entity.Book;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;
import java.util.List;


public interface BookRepository extends MongoRepository<Book, Integer> {


    @Query(  "  {  quantity: {$gt: 0 }  }    "  )
    List<Book> findAllAvailable();

    @Query(  "  { genre: ?0 }")
    List<Book> findSelectGenre(String _genre);

    @Query(value = " { 'genre': {$ne: false }}", fields = "{ 'id':0, 'title':0, 'pageCount':0, 'isbn':0, 'author':0, 'imgPath':0, '_class':0, 'quantity':0, 'price':0 } + ")
    List<String> findAllGenres();


}
