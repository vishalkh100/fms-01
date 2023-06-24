package com.example.demo.models;

import lombok.Data;

@Data
public class ResponseObject {
    private String status;
    private String message;
    private String token;

    public ResponseObject() {
    }

    public ResponseObject(String status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }
}
