package com.example.demo.repository;

import com.example.demo.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users save(Users users);
    List<Users> findAll();
    Optional<Users> findById(Integer id);
    void delete(Users users);
}
