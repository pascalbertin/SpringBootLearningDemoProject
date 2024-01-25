package com.spring.learning.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceholderConfiguration {

    @Bean("jsonplaceholder")
    CommandLineRunner runner(JSONPlaceholderClient jsonPlaceholderClient) {
        return args -> {
            System.out.println("Number of all posts: " + jsonPlaceholderClient.getPosts().size());
            System.out.println("Post number 1: " + jsonPlaceholderClient.getPost(1));
        };
    }
}
