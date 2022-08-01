package com.koolJavaProjekts.bugTracker.Services;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class NewUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    PasswordEncoder passwordEncoder = passwordEncoder();

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> listOfUsers = userRepository.findAll();
        for (User user : listOfUsers) {
            //in this case nickname = email
            if (user.getEmail().equals(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("Username not found");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
