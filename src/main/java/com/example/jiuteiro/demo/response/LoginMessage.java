package com.example.jiuteiro.demo.response;

public class LoginMessage {
    String message;
    Boolean status;

    public LoginMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginMessage() {
    }

    public String getMessage() {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
