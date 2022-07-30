package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserRepository userRepository;

    @GetMapping("/user/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/user/add")
    public void addUser(User user){
        userRepository.save(user);
    }

    @PostMapping("/user/update")
    public void updateUser(User newUser){
        for (User user : userRepository.findAll()) {
            if (user.getId() == newUser.getId()) {
                user.setName(newUser.getName());
                user.setSurname(newUser.getSurname());
                user.setEmail(newUser.getEmail());
                user.setNickname(newUser.getNickname());
                user.setPassword(newUser.getPassword());
                user.setImage(newUser.getImage());
                user.setTeam(newUser.getTeam());
            }
        }
    }

    @DeleteMapping("/user/delete")
    public void deleteUser(User deleteUser){
        for (User user : userRepository.findAll()) {
            if (user.getId() == deleteUser.getId()){
                userRepository.delete(user);
            }
        }
    }

}
