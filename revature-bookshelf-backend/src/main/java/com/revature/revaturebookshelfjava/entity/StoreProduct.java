package com.revature.revaturebookshelfjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "store_inventory")
public class StoreProduct {

    @Id
    @Column(name = "book_id")
    @JsonIgnore
    private int id;
    @OneToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;
    private int quantity;
    private float price;
}
