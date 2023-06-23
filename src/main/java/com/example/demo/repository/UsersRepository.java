package com.example.demo.repository;

import com.example.demo.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface UsersRepository extends JpaRepository<Users, Integer> {
    public Users save(Users users);
    public List<Users> findAll();
}
