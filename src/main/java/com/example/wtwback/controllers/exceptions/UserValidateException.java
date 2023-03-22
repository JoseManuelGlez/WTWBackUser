package com.example.wtwback.controllers.exceptions;

public class UserValidateException extends  RuntimeException{
    public UserValidateException(String message) {
        super(message);
    }
}
