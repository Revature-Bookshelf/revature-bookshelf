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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "auth_join",
    joinColumns = { @JoinColumn(name = "user_id")},
    inverseJoinColumns = { @JoinColumn(name = "auth_id")})
    private List<String> authorities;

    @Override
    public String toString() {
        return String.format("User[id='%s', email='%s', username=='%s', password=='%s', firstName=='%s',middleName=='%s',lastName=='%s'", id, email, username, password, firstName, middleName, lastName);
    }
}