package com.booking.jpahotelbooking.controller;

import com.booking.jpahotelbooking.entity.dto.registration.RegistrationRequestDTO;
import com.booking.jpahotelbooking.service.RegistrationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.booking.jpahotelbooking.entity.Registration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> getAll() {

        return new ResponseEntity<>(
                registrationService.getAllRegistration(),
                HttpStatus.OK
        );
    }

    @GetMapping("/byTime")
    public ResponseEntity<List<Registration>> getAllRegistrationByTime(
            @RequestParam LocalDateTime timeIn) {

        return new ResponseEntity<>(
                registrationService.getRegistrationByTsCheckIn(timeIn),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Registration> createRoom(
            @RequestBody @Validated RegistrationRequestDTO registrationRequestDTO) {

        return new ResponseEntity<>(
                registrationService.addRegistration(registrationRequestDTO),
                HttpStatus.CREATED
        );
    }
}