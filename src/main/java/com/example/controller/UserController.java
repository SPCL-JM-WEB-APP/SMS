package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.UserDetails;
import com.example.repository.UserRepository;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String home(Model model) {
    //   model.addAttribute("successMessage", "Data saved successfully..");
        return "index";
   }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDetails user, Model model) {
        System.out.println(user);
        repo.save(user);
        model.addAttribute("successMessage", "Congratulations! Registration successful.");
        return "index.html";
    }
}
