package com.booking.jpahotelbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeNotModifiedException extends ResponseStatusException {

    public EmployeeNotModifiedException(String message) {
        super(HttpStatus.NOT_MODIFIED, message);
    }
}