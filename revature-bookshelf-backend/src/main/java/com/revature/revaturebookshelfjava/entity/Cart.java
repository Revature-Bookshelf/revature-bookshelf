package com.revature.revaturebookshelfjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
    @ManyToMany
    @JoinTable( name = "cart_join",
    joinColumns = { @JoinColumn(name = "cart_id")},
    inverseJoinColumns = { @JoinColumn(name = "book_id")})
    private List<Book> books;
    @OneToMany(mappedBy = "cart")
    private List<Order> orders;

    public Cart(int id) {
        this.id = id;
    }
}