package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("users/all")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public Users getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }

}
