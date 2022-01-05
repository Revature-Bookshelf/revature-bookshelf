package com.revature.revaturebookshelfjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RevatureBookshelfJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RevatureBookshelfJavaApplication.class, args);
    }

}
