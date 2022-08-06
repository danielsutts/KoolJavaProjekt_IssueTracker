package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.configs.InMemorySessionRegistry;
import com.koolJavaProjekts.bugTracker.dto.IssueDTO;
import com.koolJavaProjekts.bugTracker.dto.ResponseDTO;
import com.koolJavaProjekts.bugTracker.dto.UserDTO;
import com.koolJavaProjekts.bugTracker.models.Issue;
import com.koolJavaProjekts.bugTracker.models.User;
import com.koolJavaProjekts.bugTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
        this.manager.authenticate(token);
        final String sessionId = sessionRegistry.registerSession(userDTO.getUsername());

        ResponseDTO response = new ResponseDTO();
        response.setSessionId(sessionId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody UserDTO userDTO) {
        User newUser = new User();
        newUser.setEmail(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(newUser);
        return loginUser(userDTO);
    }

    @GetMapping("/user/me")
    public ResponseEntity<ResponseDTO> getUsername(HttpSession session) throws Exception{
        String sessionId = session.getId();
        if (sessionId == null || sessionId.equals("") || sessionRegistry.sessionIsRegistered(sessionId)) {
            throw new Exception("Authentication failed. No key no cookies.");
        }
        String response = sessionRegistry.getUsernameForSession(sessionId);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSessionId(response);
        System.out.println(responseDTO.getSessionId());
        return ResponseEntity.ok(responseDTO);
    }
}
