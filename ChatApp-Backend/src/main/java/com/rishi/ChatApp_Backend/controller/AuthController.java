package com.rishi.ChatApp_Backend.controller;

import com.rishi.ChatApp_Backend.dto.AuthResponse;
import com.rishi.ChatApp_Backend.dto.LoginRequest;
import com.rishi.ChatApp_Backend.dto.RegisterRequest;
import com.rishi.ChatApp_Backend.service.AuthService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    Register API

    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}
