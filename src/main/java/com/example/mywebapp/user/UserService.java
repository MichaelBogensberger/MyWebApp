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




    // Methoden für den RestController
    public User apiUpdateUser(Integer id, User givenUser) {
        User foundUser = repo.findById(id).get();

        foundUser.setFirstname(givenUser.getFirstname());
        foundUser.setLastname(givenUser.getLastname());
        foundUser.setPassword(givenUser.getPassword());
        foundUser.setEmail(givenUser.getEmail());
        foundUser.setEnabled(givenUser.getEnabled());

        return repo.save(foundUser);
    }

    public void apiDeleteUser(Integer id) {
        repo.deleteById(id);
    }



}
