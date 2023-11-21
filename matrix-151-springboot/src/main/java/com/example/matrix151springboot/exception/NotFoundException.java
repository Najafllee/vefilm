package com.example.matrix151springboot.exception;
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
