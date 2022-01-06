package com.revature.revaturebookshelfjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RevatureBookshelfJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RevatureBookshelfJavaApplication.class, args);
    }

}
