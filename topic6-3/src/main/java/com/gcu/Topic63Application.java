package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan({"com.gcu"}) //make spring scan our package for controller, etc.
public class Topic63Application {

    public static void main(String[] args) {
        SpringApplication.run(Topic63Application.class, args);

        // Generate a new encoded password
        String plainTextPassword = "password123";
        String newEncoded = new BCryptPasswordEncoder().encode(plainTextPassword);
        System.out.println("Newly Encoded password: " + newEncoded);

        // Test if your stored hash matches "password123"
        String storedHash = "$2a$10$DUUavT7msGJ5eORIooA/YewjWQMJxlSsZz1VR6yJ2frdiQCEr3Yum";
        boolean match = new BCryptPasswordEncoder().matches("password123", storedHash);
        System.out.println("Password matches stored hash? " + match);
    }
}
