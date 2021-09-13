package com.example.AZplastering.payload.response;

public class MessageResponse {
    private String message;
    private Boolean error;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}