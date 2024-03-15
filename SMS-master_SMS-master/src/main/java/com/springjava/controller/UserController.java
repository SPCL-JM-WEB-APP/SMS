package com.springjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springjava.entity.*;
import com.springjava.repository.UserRepository;



@Controller
public class UserController {
    
    @Autowired
    private UserRepository repo;

    @GetMapping("/indextech")
    public String home(Model model) {
//        model.addAttribute("successMessage", "Data saved successfully..");
        return "indextech";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDetails user, Model model) {
        System.out.println(user);
        repo.save(user);
        model.addAttribute("successMessage", "Congratulations! Registration successful.");
        return "indextech";
    }
}
