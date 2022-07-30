package com.koolJavaProjekts.bugTracker.repositories;

import com.koolJavaProjekts.bugTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
