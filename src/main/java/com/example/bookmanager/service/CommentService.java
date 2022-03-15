package com.example.bookmanager.service;

import com.example.bookmanager.domain.Comment;
import com.example.bookmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init() {
        for (int i = 0; i <10; i++) {
            Comment comment = new Comment();
            comment.setComment("최고에요");

            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly = true) // dirty check를 하지 않는다.
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        for (Comment comment : comments) {
            comment.setComment("별로에요");

//            commentRepository.save(comment);  // save메소드를 실행하지 않더라도 영속성 관리중에는 자동으로 save메소드를 실행한다. (dirty check)
        }
    }

    @Transactional
    public void insertSomething() {
//        Comment comment = new Comment();  // 영속화x
        Comment comment = commentRepository.findById(1L).get(); // 영속화
        comment.setComment("이건뭐죠");

//        commentRepository.save(comment);
    }
}
