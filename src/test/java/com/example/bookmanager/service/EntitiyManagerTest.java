package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntitiyManagerTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void EntityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList()); // userRepository.findAll()
    }

    @Test
    void cacheFindTest() {
//        System.out.println(userRepository.findByEmail("njh4803@gmail.com"));
//        System.out.println(userRepository.findByEmail("njh4803@gmail.com"));
//        System.out.println(userRepository.findByEmail("njh4803@gmail.com"));
//        System.out.println(userRepository.findById(2L).get());
//        System.out.println(userRepository.findById(2L).get());
//        System.out.println(userRepository.findById(2L).get());

        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("노지형혀여형");

        userRepository.save(user);
        //userRepository.flush();

        System.out.println("====================================");

        user.setEmail("asdasdasdad@gmail.com");

        userRepository.save(user);
        //userRepository.flush();

        System.out.println(">>> 1 : " + userRepository.findById(1L).get());

        userRepository.flush();

        System.out.println(">>> 2 : " + userRepository.findById(1L).get());
    }
}
