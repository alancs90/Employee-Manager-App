package com.alan.employeemanager.exception;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -2283581411559187815L;

    public UserNotFoundException(String message) {

        super(message);
    }
}
