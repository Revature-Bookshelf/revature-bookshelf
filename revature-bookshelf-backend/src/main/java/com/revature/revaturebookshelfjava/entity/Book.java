package com.revature.revaturebookshelfjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    @NotNull
    private String title;
    @Column(name = "pagecount")
    private int pageCount;
    @Column(name = "publishdate")
    private Date publishDate;
    @Column(unique = true)
    private String isbn;
    private String author;

    @ManyToMany
    @JoinTable(name = "genre_join",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private List<Genre> genres;
    @Column(name = "imgpath")
    private String imgPath;

    @ManyToMany(mappedBy = "ownedBooks")
    @JsonIgnore
    private List<User> owners;

    @OneToOne(mappedBy = "book")
    private StoreProduct priceAndQuantity;

    public Book(String title, int pageCount, Date publishDate, String isbn, String author, List<Genre> genres, String imgPath) {
        this.title = title;
        this.pageCount = pageCount;
        this.publishDate = publishDate;
        this.isbn = isbn;
        this.author = author;
        this.genres = genres;
        this.imgPath = imgPath;
    }
}
