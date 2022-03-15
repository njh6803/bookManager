package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest() { // FetchType.EAGER 와 FetchType.LAZY 차이와 N+1이슈
        List<Review> reviews = reviewRepository.findAll();
//        List<Review> reviews = reviewRepository.findAllByFetchJoin();
//        List<Review> reviews = reviewRepository.findAllByEntityGraph();

//        System.out.println(reviews);
//        System.out.println("전체를 가져왔습니다");
//
//        System.out.println(reviews.get(0).getComments());
//
//        System.out.println("첫번째 리뷰의 코멘트들을 가져왔습니다.");
//
//        System.out.println(reviews.get(1).getComments());
//
//        System.out.println("두번째 리뷰의 코멘트들을 가져왔습니다.");

        reviews.forEach(System.out::println);
    }
}
