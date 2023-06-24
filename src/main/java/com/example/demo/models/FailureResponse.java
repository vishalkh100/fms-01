package com.example.demo.models;

import lombok.Data;

@Data
public class FailureResponse {
    private String responseMessage;

    public FailureResponse(String message) {
        responseMessage = message;
    }
}
