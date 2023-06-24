package com.example.demo.models;

import lombok.Data;

@Data
public class SuccessResponse {
    private String responseMessage;

    public SuccessResponse(String message) {
        responseMessage = message;
    }
}
