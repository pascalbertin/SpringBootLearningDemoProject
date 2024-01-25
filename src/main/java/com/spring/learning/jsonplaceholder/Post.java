package com.spring.learning.jsonplaceholder;

public record Post(Integer id,
                   Integer userId,
                   String title,
                   String body) {
}