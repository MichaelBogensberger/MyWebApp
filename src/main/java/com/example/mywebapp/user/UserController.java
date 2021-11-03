package com.example.mywebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;


    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> usersList = service.listAll();
        model.addAttribute("usersList", usersList);

        return "users";
    }


    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }


    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        service.save(user);
        ra.addFlashAttribute("message", "User has been saved");
        return "redirect:/users";
    }


    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model ) {
        User user = service.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle" , " Edit User: " + id);


        return "edit";
    }


    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {

        service.deleteById(id);
        return "redirect:/users";
    }

}
