package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.configs.InMemorySessionRegistry;
import com.koolJavaProjekts.bugTracker.dto.ResponseDTO;
import com.koolJavaProjekts.bugTracker.dto.UserDTO;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/*
    Controller for Authentication.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager manager;
    @Autowired
    private final InMemorySessionRegistry sessionRegistry;

    public ApiController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, AuthenticationManager manager, InMemorySessionRegistry sessionRegistry) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.manager = manager;
        this.sessionRegistry = sessionRegistry;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody UserDTO userDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        System.out.println("Hello: " + token.toString());

        this.manager.authenticate(token);
        final String sessionId = sessionRegistry.registerSession(userDTO.getUsername());

        ResponseDTO response = new ResponseDTO();
        response.setSessionId(sessionId);
        return ResponseEntity.ok(response);
    }
}
