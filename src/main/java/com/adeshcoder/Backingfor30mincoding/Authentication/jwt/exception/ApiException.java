package com.adeshcoder.Backingfor30mincoding.Authentication.jwt.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);

    }

    public ApiException() {
        super();
    }


}