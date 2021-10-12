package com.bridgelabz.employeepayroll.exception;

public class ValidationExceptionHandler extends RuntimeException{
    public ValidationExceptionHandler(String message) {
        super(message);
    }
}
