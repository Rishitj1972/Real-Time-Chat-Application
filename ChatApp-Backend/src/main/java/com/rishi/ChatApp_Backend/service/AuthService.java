package com.rishi.ChatApp_Backend.service;

import com.rishi.ChatApp_Backend.dto.AuthResponse;
import com.rishi.ChatApp_Backend.dto.RegisterRequest;
import com.rishi.ChatApp_Backend.model.User;
import com.rishi.ChatApp_Backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saved = userRepository.save(user);

        return mapToResponse(saved);
    }

    public AuthResponse mapToResponse(User user) {

        AuthResponse dto = new AuthResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());

        return dto;
    }


}
