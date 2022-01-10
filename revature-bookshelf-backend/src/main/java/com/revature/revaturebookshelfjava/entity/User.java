package com.revature.revaturebookshelfjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "auth_join",
    joinColumns = { @JoinColumn(name = "user_id")},
    inverseJoinColumns = { @JoinColumn(name = "auth_id")})
    private List<Authority> authorities;
    @OneToOne(mappedBy = "user")
    private Cart cart;
    @ManyToMany
    @JoinTable(name = "address_join",
    joinColumns = { @JoinColumn(name = "user_id")},
    inverseJoinColumns = { @JoinColumn(name = "address_id")})
    private List<Address> addresses;
    @ManyToMany
    @JoinTable(name = "client_inventory",
            joinColumns = { @JoinColumn (name = "user_id")},
            inverseJoinColumns = { @JoinColumn (name = "book_id")})
    private List<Book> ownedBooks;

    @Override
    public String toString() {
        return String.format("User[id='%s', email='%s', username=='%s', password=='%s', firstName=='%s',middleName=='%s',lastName=='%s'", id, email, username, password, firstName, middleName, lastName);
    }
}