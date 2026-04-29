package com.rishi.ChatApp_Backend.dto;

import com.rishi.ChatApp_Backend.model.User;

public class AuthResponse {

    private Long id;
    private String username;
    private String email;
    private String token;

    public AuthResponse() {

    }

    public AuthResponse(String token, User user) {
        this.token = token;
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
