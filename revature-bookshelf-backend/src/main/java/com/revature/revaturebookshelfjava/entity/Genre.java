package com.revature.revaturebookshelfjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    @Column(name = "genre", unique = true)
    @NotNull
    private String name;
    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private List<Book> books;

}
