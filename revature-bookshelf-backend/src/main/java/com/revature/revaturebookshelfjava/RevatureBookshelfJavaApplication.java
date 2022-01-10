package com.revature.revaturebookshelfjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories
public class RevatureBookshelfJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RevatureBookshelfJavaApplication.class, args);
    }

    // TODO: Resolve @Bean conflict ?
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
