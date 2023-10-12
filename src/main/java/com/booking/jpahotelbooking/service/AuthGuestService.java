package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.auth.util.JWTTokenUtils;
import com.booking.jpahotelbooking.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class AuthGuestService {

    private final JWTTokenUtils jwtTokenUtils;
    private final GuestService guestService;

}