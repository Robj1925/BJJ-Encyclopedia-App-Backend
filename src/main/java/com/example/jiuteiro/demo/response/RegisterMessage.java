package com.example.jiuteiro.demo.response;

public class RegisterMessage {
    String message;
    Boolean status;

    public RegisterMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
    public RegisterMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
