package com.booking.jpahotelbooking.auth.controller;

import com.booking.jpahotelbooking.auth.dto.RegistrationEmployeeDTO;
import com.booking.jpahotelbooking.service.AuthEmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.booking.jpahotelbooking.auth.dto.LoginEmployeeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthEmployeeService authEmployeeService;

    @PostMapping("/registration")
    public ResponseEntity<?> createEmployee(
            @RequestBody RegistrationEmployeeDTO registrationEmployeeDTO) {

        return new ResponseEntity<>(
                authEmployeeService.createEmployee(registrationEmployeeDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(
            @RequestBody LoginEmployeeDTO loginEmployeeDTO) {

        return new ResponseEntity<>(
                authEmployeeService.loginEmployee(loginEmployeeDTO),
                HttpStatus.OK
        );
    }
}