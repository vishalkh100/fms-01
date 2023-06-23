package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import exceptions.ExceptionResponseException;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    GsonJsonParser gsonJsonParser = new GsonJsonParser();
    @Autowired
    UsersService usersService;

    @GetMapping("users/")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public Users getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }

    @PostMapping("users/")
    @ResponseStatus(value= HttpStatus.OK)
    public Users addNewUser(@RequestBody Users user) {
        return usersService.addNewUser(user);
    }

    @DeleteMapping("users/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        Users user = null;
        try {
            user = usersService.deleteUser(id);
        } catch (ExceptionResponseException e) {
            System.out.println(e.getMessage());
        }
        return gsonJsonParser.toString();    }
}
