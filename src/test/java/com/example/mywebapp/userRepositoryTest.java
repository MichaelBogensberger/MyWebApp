package com.example.mywebapp;

import com.example.mywebapp.user.User;
import com.example.mywebapp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class userRepositoryTest {
    @Autowired private UserRepository repo;


    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("agen1@gmail.com");
        user.setPassword("123");
        user.setFirstname("much");
        user.setLastname("bogo");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testDeleteUser() {
        User user = repo.findById(2).get();


       System.out.println("Erster Name:" + user.getFirstname());
        repo.delete(user);

    }


    @Test
    public void testListAll() {
        Iterable<User> all = repo.findAll();

        Assertions.assertThat(all).hasSizeGreaterThan(0);

        for(User user: all ) {
            System.out.println(user);
        }


    }




}
