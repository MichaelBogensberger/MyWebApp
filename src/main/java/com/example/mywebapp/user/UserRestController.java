package com.example.mywebapp.user;

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



    // HTTP REQUESTS

    // Alle User zurückgeben
    @RequestMapping("/api/allUsers")
    public List<User> apiShowUserList() {
        return service.listAll();
    }

    // neuen User anlegen
    @RequestMapping(method = RequestMethod.POST, value= "/api/createUser")
    public String createUser(@RequestParam String first, String last, String email, String pw, boolean enabled) {

        User user = new User();
        user.setFirstname(first);
        user.setLastname(last);
        user.setEmail(email);
        user.setEnabled(enabled);
        user.setPassword(pw);

        service.save(user);

        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + pw + '\'' +
                ", firstname='" + first + '\'' +
                ", lastname='" + last + '\'' +
                ", enabled='" + enabled + '\'' +
                "} wurde angelegt";
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








    }
