package com.example.service;

import com.example.dto.UserResponse;
import com.example.entities.User;
import com.example.exception.UserNotFoundException;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public UserResponse findByName(String name) {
        if (userRepository.existsByName(name)) {
            User user = userRepository.findByName(name);
            return UserResponse.fromUser(user);
        }
        else {
            throw new UserNotFoundException("User not found with the given name");
        }
    }

    @Override
    public UserResponse findByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            User user = userRepository.findByEmail(email);
            return UserResponse.fromUser(user);
        }
        else {
            throw new UserNotFoundException("User not found with the given email");
        }
    }

    @Override
    public Boolean doUserExist(String name, String email) {
        return userRepository.existsByNameOrEmail(name, email);
    }
}
