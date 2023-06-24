package com.example.demo.models.dto;

import com.example.demo.enums.UserType;
import lombok.Data;

@Data
public class AuthDTO {
    private String username;
    private String password;
    private int userId;

    @Override
    public String toString() {
        return "AuthDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}
