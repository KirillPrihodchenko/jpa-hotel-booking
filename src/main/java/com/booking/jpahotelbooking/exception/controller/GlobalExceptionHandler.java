package com.booking.jpahotelbooking.exception.controller;

import com.booking.jpahotelbooking.exception.RoomStatusIsNotUpdatedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResponseStatusException.class, NoSuchElementException.class})
    public ResponseEntity<ApiError> handleExist(
            ResponseStatusException ex, HttpServletRequest hsr) {

        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                hsr.getRequestURI(),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(
                apiError, HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({RoomStatusIsNotUpdatedException.class, RuntimeException.class})
    public ResponseEntity<ApiError> handleNotUpdated(
            ResponseStatusException ex, HttpServletRequest hsr) {

        ApiError apiError = new ApiError(
                HttpStatus.NOT_MODIFIED.value(),
                hsr.getRequestURI(),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(
                apiError, HttpStatus.NOT_MODIFIED
        );
    }
}