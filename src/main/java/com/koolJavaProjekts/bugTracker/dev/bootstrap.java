package com.koolJavaProjekts.bugTracker.dev;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;

public class bootstrap implements CommandLineRunner {
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("danya@tech", "12345678", 1L));
        userRepository.save(new User("vlad@tech", "12345678", 2L));
        userRepository.save(new User("max@tech", "12345678", 3L));
        for (User user: userRepository.findAll()) {
            System.out.println(user.getEmail());
        }
    }
}
