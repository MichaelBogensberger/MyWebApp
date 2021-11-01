package com.example.mywebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }


    public void save(User user) {
        repo.save(user);
    }

    public User getById(Integer id) {
        return repo.findById(id).get();
    }


    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

}
