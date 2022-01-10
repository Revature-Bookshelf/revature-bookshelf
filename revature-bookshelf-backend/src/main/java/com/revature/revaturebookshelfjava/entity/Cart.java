package com.revature.revaturebookshelfjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "carts")
public class Cart  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinTable( name = "cart_join",
    joinColumns = { @JoinColumn(name = "cart_id")},
    inverseJoinColumns = { @JoinColumn(name = "book_id")})
    private Book books;

}