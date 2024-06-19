package com.adeshcoder.Backingfor30mincoding.Authentication.jwt.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}