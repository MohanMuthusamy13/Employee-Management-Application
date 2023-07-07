package com.example.service;

import com.example.dto.UserResponse;
import com.example.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse findByName(String name);

    UserResponse findByEmail(String email);

    Boolean doUserExist(String name, String email);
}
