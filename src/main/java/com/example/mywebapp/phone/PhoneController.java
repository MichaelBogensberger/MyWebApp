package com.example.mywebapp.phone;

import com.example.mywebapp.user.User;
import com.example.mywebapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

@Controller
public class PhoneController {

    @Autowired
    private PhoneService phoneService;


    @GetMapping("/users/details/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model ) {


        List<String> numbers = phoneService.getNumberByUserId(id);
        List<String> anbieter = phoneService.getAnbieterByUserId(id);
        List<String> companyIds = phoneService.getIdByUserId(id);


        model.addAttribute("numbers", numbers);
        model.addAttribute("anbieter", anbieter);
        model.addAttribute("companyIds", companyIds);




        return "details";
    }







}
