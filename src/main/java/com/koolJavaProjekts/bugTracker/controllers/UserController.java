package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
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
