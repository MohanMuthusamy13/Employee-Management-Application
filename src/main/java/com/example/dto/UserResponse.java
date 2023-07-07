package com.example.dto;

import com.example.entities.Role;
import com.example.entities.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
public class UserResponse {
    private long id;
    private String name;
    private String email;
    private Set<String> roles;

    public static UserResponse fromUser(User user) {
        Set<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        return new UserResponse()
                .setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setRoles(roles);
    }
}
