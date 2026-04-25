package com.rishi.ChatApp_Backend.Repository;

import com.rishi.ChatApp_Backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
