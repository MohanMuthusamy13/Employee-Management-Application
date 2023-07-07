package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
