package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Address;
import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void crud(){ // created read update delete
        //List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        //List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

        /*User user1 = new User("jack", "jack@gmail.com");
        User user2 = new User("steve", "steve@gmail.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);*/

        /*User user = userRepository.findById(1L).orElse(null);
        System.out.println(user);*/

        //userRepository.save(new User("new noji", "noji@gmail.com"));
        //userRepository.flush();

        /*userRepository.saveAndFlush(new User("new noji", "noji@gmail.com"));
        userRepository.findAll().forEach(System.out::println);*/

        /*long count = userRepository.count();
        System.out.println(count);*/

        /*boolean exists = userRepository.existsById(1L);
        System.out.println(exists);*/

        //userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        //userRepository.deleteById(1L);
        //userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
        //userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));

/*        Page<User> users = userRepository.findAll(PageRequest.of(0, 3));
        System.out.println("page : " + users);
        System.out.println("totalElements : " + users.getTotalElements());
        System.out.println("totalPages : " + users.getTotalPages());
        System.out.println("numberOfElements : " + users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size : " + users.getSize());

        users.getContent().forEach(System.out::println);*/

        /*ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<User> example = Example.of(new User("gm", "gmail.com"), matcher);*/

        /*User user = new User();
        user.setEmail("njh4803@gmail.com");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);*/

        userRepository.save(new User("david", "david@gmail.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("njh4803@naver.com");

        userRepository.save(user);
    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("노지형"));
//        System.out.println("findByEamil : " + userRepository.findByEmail("njh4803@gmail.com"));
//        System.out.println("getByEamil : " + userRepository.getByEmail("njh4803@gmail.com"));
//        System.out.println("readByEamil : " + userRepository.readByEmail("njh4803@gmail.com"));
//        System.out.println("queryByEamil : " + userRepository.queryByEmail("njh4803@gmail.com"));
//        System.out.println("searchByEamil : " + userRepository.searchByEmail("njh4803@gmail.com"));
//        System.out.println("streamByEamil : " + userRepository.streamByEmail("njh4803@gmail.com"));
//        System.out.println("findUserByEamil : " + userRepository.findUserByEmail("njh4803@gmail.com"));
//        System.out.println("findSometingByEamil : " + userRepository.findSomethingByEmail("njh4803@gmail.com"));
//
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("노지형"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("노지형"));

//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("njh4803@gmail.com", "노지형"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("njh4803@gmail.com", "노지원"));
//
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//
//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
//
//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("노지형", "노지원")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("노"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("형"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("지"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%지%"));
    }

    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("노지형"));
        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("노지형"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("노지형"));
        //System.out.println("findFirstByName : " + userRepository.findFirstByName("노지형", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("노지형", getSort()));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("노지형", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.desc("email")
        );
    }

    @Test
    void insertAndUpdateTest(){
        User user = new User();
        user.setName("노지형");
        user.setEmail("njh4803@nate.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("노노노노노노지형");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("njh4803@naver.com");
        user.setName("노지형");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("노지노지노지형");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("njh4803@naver.com");
        user.setName("노지형");
        /*user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());*/

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("njh4803@naver.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("노지형");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("njh4803@naver.com");
        user.setName("노지형");

        userRepository.save(user);

        user.setName("노지형노지형노지형");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("노지형");
        user.setEmail("njh4803@naver.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);

        user.setName("노지형형");
        userRepository.save(user);

        user.setEmail("njh4803njh4803@gmail.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

        /*List<UserHistory> result = userHistoryRepository.findByUserId(
                userRepository.findByEmail("njh4803njh4803@gmail.com").getId());*/

        List<UserHistory> result = userRepository.findByEmail("njh4803njh4803@gmail.com").getUserHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());
    }

    @Test
    void embedTest() {
        userRepository.findAll().forEach(System.out::println);

        User user = new User();
        user.setName("steve");
        user.setEmail("steve@gmail.com");
        user.setHomeAddress(new Address("서울시", "강남구", "강남대로 364 미왕빌딩", "06241"));
        user.setCompanyAddress(new Address("서울시", "성동구", "성수이로 113 제강빌딩", "04794"));

        userRepository.save(user);

        User user1 = new User();
        user1.setName("joshua");
        user1.setEmail("joshua@gmail.com");
        user1.setHomeAddress(null);
        user1.setCompanyAddress(null);

        userRepository.save(user1);

        User user2 = new User();
        user2.setName("jordan");
        user2.setEmail("jordan@gmail.com");
        user2.setHomeAddress(new Address());
        user2.setCompanyAddress(new Address());

        userRepository.save(user2);

        entityManager.clear();

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);

        userRepository.findAllRawRecord().forEach(a -> System.out.println(a.values()));

        assertAll(
                () -> assertThat(userRepository.findById(7L).get().getHomeAddress()).isNull(),
                () -> assertThat(userRepository.findById(8L).get().getHomeAddress()).isInstanceOf(Address.class)
        );
    }
}