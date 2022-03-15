package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void commentTest() {    // cache 조회값과 DB 조회값이 다른 경우
//        Comment comment = commentRepository.findById(3L).get();
        Comment comment = new Comment();
        comment.setComment("별로에요");
//        comment.setCommentedAt(LocalDateTime.now());

        commentRepository.saveAndFlush(comment);

        entityManager.clear();

//        System.out.println(commentRepository.findById(3L).get());
        System.out.println(comment);

        commentRepository.findAll().forEach(System.out::println);
    }
}