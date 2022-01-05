package com.revature.revaturebookshelfjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="users")
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String username;
    @Field
    private String password;
    @Field
    private String firstName;
    @Field
    private String middleName;
    @Field
    private String lastName;
    private List<String> authorities;

    @Override
    public String toString() {
        return String.format("User[id='%s', email='%s', username=='%s', password=='%s', firstName=='%s',middleName=='%s',lastName=='%s'", id, email, username, password, firstName, middleName, lastName);
    }
}