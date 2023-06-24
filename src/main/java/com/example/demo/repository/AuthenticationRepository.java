package com.example.demo.repository;

import com.example.demo.entity.Authentication;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
    public Authentication findByUsername(String username);
}
