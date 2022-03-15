package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    public void put() {
        User user = new User();
        user.setName("노지형");
        user.setEmail("newUser@gmail.com");

        //userRepository.save(user);

        entityManager.persist(user);
        //entityManager.detach(user);

        user.setName("newUserAfterPersist");
        entityManager.merge(user);

        //entityManager.flush();
        //entityManager.clear();

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

//        user1.setName("노지원");
//        entityManager.merge(user1);
    }
}
