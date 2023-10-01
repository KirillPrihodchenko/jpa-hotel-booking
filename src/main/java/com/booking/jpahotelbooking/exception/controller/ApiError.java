package com.booking.jpahotelbooking.exception.controller;

import java.time.LocalDateTime;

public record ApiError(
        int statusCode,
        String path,
        String message,
        LocalDateTime localDateTime) { }