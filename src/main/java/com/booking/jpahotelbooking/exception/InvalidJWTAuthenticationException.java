package com.booking.jpahotelbooking.exception;

public class InvalidJWTAuthenticationException extends RuntimeException {

    public InvalidJWTAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
