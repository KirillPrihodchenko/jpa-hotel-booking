package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.auth.dto.JWTResponseDTO;
import com.booking.jpahotelbooking.auth.dto.LoginEmployeeDTO;
import com.booking.jpahotelbooking.auth.dto.RegistrationEmployeeDTO;
import com.booking.jpahotelbooking.entity.dto.employee.EmployeeResponseDTO;
import com.booking.jpahotelbooking.auth.util.JWTTokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor

@Service
public class AuthEmployeeService {

    private final JWTTokenUtils jwtTokenUtils;
    private final EmployeeService employeeService;
    private final AuthenticationManager authenticationManager;


    public EmployeeResponseDTO createEmployee(RegistrationEmployeeDTO registrationEmployeeDTO) {

        employeeService.createEmployee(registrationEmployeeDTO);

        return new EmployeeResponseDTO(
                registrationEmployeeDTO.getFirstName(),
                registrationEmployeeDTO.getLastName()
        );
    }

    public JWTResponseDTO loginEmployee(LoginEmployeeDTO loginEmployeeDTO) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginEmployeeDTO.getEmail(),
                            loginEmployeeDTO.getPassword())
            );
        }
        catch (BadCredentialsException ex) {

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email or Password hasn't correct");
        }

        UserDetails userDetails = employeeService.loadUserByUsername(loginEmployeeDTO.getEmail());
        String token = jwtTokenUtils.generateJWTToken(userDetails);

        return new JWTResponseDTO(token);
    }
}