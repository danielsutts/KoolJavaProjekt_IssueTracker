package com.koolJavaProjekts.bugTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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
