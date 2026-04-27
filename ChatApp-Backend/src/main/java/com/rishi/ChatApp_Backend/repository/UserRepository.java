package com.rishi.ChatApp_Backend.repository;

import com.rishi.ChatApp_Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
