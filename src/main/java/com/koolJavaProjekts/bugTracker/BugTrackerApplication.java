package com.koolJavaProjekts.bugTracker;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BugTrackerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}

	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("danya@tech", "12345678", 1L));
		userRepository.save(new User("vlad@tech", "12345678", 2L));
		userRepository.save(new User("max@tech", "12345678", 3L));
	}
}
