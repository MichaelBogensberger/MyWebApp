package com.example.mywebapp.phone;

import com.example.mywebapp.user.User;
import com.example.mywebapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class PhoneRestController {

    @Autowired
    private PhoneService phoneService;


    // Telefonnummer hinzufügen
    @RequestMapping(method = RequestMethod.POST, value= "/api/addPhone")
    public String addPhone(@RequestParam Integer userId, String email, String pw, Long number, String Anbieter ) {


        return "Telefonnummer hinzugefügt";

    }








}
