package com.example.repository;

import com.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByEmail(String email);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    Boolean existsByNameOrEmail(String name, String email);
}
