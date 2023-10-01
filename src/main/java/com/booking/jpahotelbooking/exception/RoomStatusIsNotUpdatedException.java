package com.booking.jpahotelbooking.exception;

public class RoomStatusIsNotUpdatedException extends RuntimeException {

    public RoomStatusIsNotUpdatedException(String message) {
        super(message);
    }
}