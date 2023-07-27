package com.example.demo.Exceptions;

public class DoctorAlreadyExistsException extends Exception{
    public DoctorAlreadyExistsException(String message){
        super(message);
    }
}
