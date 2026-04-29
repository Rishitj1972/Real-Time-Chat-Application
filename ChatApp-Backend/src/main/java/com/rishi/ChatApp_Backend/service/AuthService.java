package com.rishi.ChatApp_Backend.service;

import com.rishi.ChatApp_Backend.dto.AuthResponse;
import com.rishi.ChatApp_Backend.dto.LoginRequest;
import com.rishi.ChatApp_Backend.dto.RegisterRequest;
import com.rishi.ChatApp_Backend.model.User;
import com.rishi.ChatApp_Backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saved = userRepository.save(user);

        return mapToResponse(saved);
    }

    public AuthResponse login(LoginRequest request) {

        User existingUser = userRepository.findByEmail(request.getEmail());

        if(existingUser == null) {
            throw new RuntimeException("User not Found");
        }

        boolean isPasswordValid = passwordEncoder.matches(request.getPassword(), existingUser.getPassword());

        if(!isPasswordValid) {
            throw new RuntimeException("Password is not Correct");
        }

        String token = jwtService.generateToken(existingUser);

        System.out.println("Token : "+token);

        return new AuthResponse(token,existingUser);
    }

    public AuthResponse mapToResponse(User user) {

        AuthResponse dto = new AuthResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());

        return dto;
    }


}
