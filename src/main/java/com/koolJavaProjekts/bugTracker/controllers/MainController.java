package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    UserRepository userRepository;

    @PostMapping("/login")
    public void createUsers() {
        userRepository.save(new User("danya@tech", "12345678", 1L));
        userRepository.save(new User("vlad@tech", "12345678", 2L));
        userRepository.save(new User("max@tech", "12345678", 3L));
        for (User user: userRepository.findAll()) {
            System.out.println(user.getEmail());
        }
    }

    @GetMapping("/")
    public String home(String name, Model model) {
        model.addAttribute("name", "guys");
        model.addAttribute("title", "Home");
        return "test";
    }

    @GetMapping("/issues")
    public String IssuesDesk(String name, Model model) {
        model.addAttribute("name", "guys");
        model.addAttribute("title", "Home");
        return "test";
    }
}
