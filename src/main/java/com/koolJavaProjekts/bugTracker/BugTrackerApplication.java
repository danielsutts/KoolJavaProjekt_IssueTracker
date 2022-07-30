package com.koolJavaProjekts.bugTracker;

import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BugTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}
}
