package com.example.demo.controller;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Users;
import com.example.demo.models.ResponseObject;
import com.example.demo.models.User;
import com.example.demo.models.dto.AuthDTO;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("auth/register")
    public ResponseObject addUser(@RequestBody Authentication auth) {
        ResponseObject response = authenticationService.addUser(auth);
        return response;
    }

    @PostMapping("auth/login")
    public ResponseObject authenticate(@RequestBody User user) {
        ResponseObject response;
        response = authenticationService.authenticate(user);
        return response;
    }

    @PutMapping("auth/update")
    public ResponseObject updatePassword(@RequestBody AuthDTO authDTO) {
        ResponseObject response = authenticationService.update(authDTO);
        return response;
    }

}
