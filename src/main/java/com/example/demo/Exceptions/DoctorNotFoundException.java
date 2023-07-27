package com.example.demo.Exceptions;

public class DoctorNotFoundException extends Exception{
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
