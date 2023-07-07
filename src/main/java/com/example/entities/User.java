package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "username", length = 60)
    private String name;

    @Column(nullable = false, name = "email_id", unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"))
    private Set<Role> roles;
}
