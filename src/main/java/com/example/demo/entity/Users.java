package com.example.demo.entity;

import com.example.demo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String email;
    private String city;
    private String contact;
    private Date registerDate;
    private Date dob;
    private Gender gender;
    private boolean hasInsuarance;
    private String address;
    private Blob profilePicture;

    @OneToOne(mappedBy = "user")
    private Authentication authentication;

}