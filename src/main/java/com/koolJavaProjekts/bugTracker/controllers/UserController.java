package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    UserRepository userRepository;

    @GetMapping("/user/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/user/add")
    public void addUser(String name, String surname, String nickname, String team, String email, String password, String image, long id){
        userRepository.save(new User(name, surname, nickname, team, email, password, image, id));
    }




}
