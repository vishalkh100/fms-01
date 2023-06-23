package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Integer id) {
        Users user = null;
        Optional<Users> optionalUser = usersRepository.findById(id);
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }
}
