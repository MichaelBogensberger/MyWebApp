package com.example.mywebapp;

import com.example.mywebapp.phone.Phone;
import com.example.mywebapp.phone.PhoneRepository;
import com.example.mywebapp.phone.PhoneService;
import com.example.mywebapp.user.User;
import com.example.mywebapp.user.UserRepository;
import com.example.mywebapp.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class userRepositoryTest {
    @Autowired private UserRepository userRepo;
    @Autowired private PhoneRepository phoneRepository;



    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("agen12@gmail.com");
        user.setPassword("1233");
        user.setFirstname("niklas");
        user.setLastname("homus");

        User savedUser = userRepo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testDeleteUser() {
        User user = userRepo.findById(2).get();


       System.out.println("Erster Name:" + user.getFirstname());
        userRepo.delete(user);

    }


    @Test
    public void testListAll() {
        Iterable<User> all = userRepo.findAll();

        Assertions.assertThat(all).hasSizeGreaterThan(0);

        for(User user: all ) {
            System.out.println(user);
        }


    }


    @Test
    public void testSetNumber() {

        Phone phone = new Phone();

        phone.setNumber(13435496L);
        phone.setAnbieter("A1");
        phone.setOwner(userRepo.findById(24).get());

        phoneRepository.save(phone);


    }



    @Test
    public void testGetNumberByUserId() {
        //User user = userRepo.findById(24).get();

       // Phone phone = phoneService.findPhoneByUserId(24);
       // Optional<Phone> phone = phoneRepository.findById(2);

        //System.out.println("PHONE -------------> " + phone.getId());




        System.out.println("Number ------------> "   + phoneRepository.findNumberByUserId(24) );
        System.out.println("Anbieter ------------> "   + phoneRepository.findAnbieterByUserId(24) );





    }






}
