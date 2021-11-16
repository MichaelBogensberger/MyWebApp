package com.example.mywebapp.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
public class UserRestController {

    @Autowired
    private UserService service;

    private final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    // HTTP REQUESTS

    // Alle User zurückgeben
    @RequestMapping("/api/allUsers")
    public List<User> apiShowUserList() {
        return service.listAll();
    }


    // neuen User anlegen
    @PostMapping(value= "/api/createUser")
    public String createUser(@RequestHeader String first,@RequestHeader String last,@RequestHeader String email,@RequestHeader String pw,@RequestHeader boolean enabled) {

            return service.apiCreateUser(first, last, email, pw, enabled);

    }


    // neuen User mit dem Object User anlegen
    @PostMapping(value= "/api/createUserFromObject")
    public String createUserFromObject(@RequestBody User user) {

        return service.apiCreateUserFromObject(user);
    }


    // User updaten
    @PutMapping("/api/updateUser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) {

        return service.apiUpdateUser(id, user);
    }

    // User löschen
    @DeleteMapping(value = "/api/deleteUser/{id}")
    public String deletePost(@PathVariable Integer id) {
        service.apiDeleteUser(id);
        return "User deleted";
    }


    // findByEmail
    @PostMapping(value ="/api/findByEmail")
    public User apiFindByEmail(@RequestHeader String email) {
        LOGGER.info("User found by Email -------------------------------------------------------------------");
        return service.findByEmail(email);
    }







    }
