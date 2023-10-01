package com.booking.jpahotelbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GuestNotModifiedException extends ResponseStatusException {

    public GuestNotModifiedException(String message) {
        super(HttpStatus.NOT_MODIFIED, message);
    }
}