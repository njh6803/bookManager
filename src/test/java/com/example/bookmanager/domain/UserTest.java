package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("njh4803@gmail.com");
        user.setName("노지형");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User user2 = user.builder()
                .name("노지형")
                .email("njh4803@gmail.com")
                .build();

        System.out.println(">>>>" + user);
    }
}