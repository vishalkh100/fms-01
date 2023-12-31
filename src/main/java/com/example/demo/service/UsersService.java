package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import exceptions.ExceptionResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();

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
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }
        return user;
    }

    public Users addNewUser(Users user) {
        user.setRegisterDate(Date.valueOf(dtf.format(now)));
        return usersRepository.save(user);
    }

    public Users deleteUser(Integer id) throws ExceptionResponseException {
        Users returnUser = null;
        Optional<Users> optionalUser = usersRepository.findById(id);
        if(optionalUser.isPresent()) {
            returnUser = optionalUser.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }
        usersRepository.delete(returnUser);
        return returnUser;
    }
}
