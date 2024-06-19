package com.adeshcoder.Backingfor30mincoding.Authentication.jwt.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}